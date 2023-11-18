package co.edu.uniquindio.proyecto.modelo.servicios.impl;

import co.edu.uniquindio.proyecto.dto.*;
import co.edu.uniquindio.proyecto.dto.paciente.*;
import co.edu.uniquindio.proyecto.modelo.entidades.*;
import co.edu.uniquindio.proyecto.modelo.enumeracion.Estado;
import co.edu.uniquindio.proyecto.modelo.enumeracion.EstadoCita;
import co.edu.uniquindio.proyecto.modelo.enumeracion.EstadoPQRS;
import co.edu.uniquindio.proyecto.modelo.repositorios.*;
import co.edu.uniquindio.proyecto.modelo.servicios.interfaces.PacienteServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor // CREA EL CONSTRUCTOR DE TODOS LOS METODOS
public class PacienteServicioImpl implements PacienteServicio {
    @Autowired
    private final PacienteRepo pacienteRepo;
    @Autowired
    private final MedicoRepo medicoRepo;
    @Autowired
    private final CitaRepo citaRepo;
    @Autowired
    private final PQRSRepo pqrsRepo;
    @Autowired
    private final CuentaRepo cuentaRepo;
    @Autowired
    private final MensajeRepo mensajeRepo;
    @Override
    public int registrarse(RegistroPacienteDTO registroPacienteDTO) throws Exception {

        if (estaRepetidoCorreo(registroPacienteDTO.correo())){
            throw new Exception("El correo "+ registroPacienteDTO.correo() +" Esta en uso");
        }

        if (EstaRepetidoCedula(registroPacienteDTO.cedula())){
            throw new Exception("La cedula "+ registroPacienteDTO.cedula() +" ya se encuentra registrada");
        }

        Paciente paciente = new Paciente();

        //DATOS DE LA CUENTA
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String passwordEncriptada = passwordEncoder.encode( registroPacienteDTO.password() );
        paciente.setPassword( passwordEncriptada );

        paciente.setCorreo(registroPacienteDTO.correo());
        //paciente.setPassword(registroPacienteDTO.password());

        //DAROS DEL USUARIO
        paciente.setNombre(registroPacienteDTO.nombre());
        paciente.setCedula(registroPacienteDTO.cedula());
        paciente.setTelefono(registroPacienteDTO.telefono());
        paciente.setUrlFoto(registroPacienteDTO.urlfoto());
        paciente.setCiudad(registroPacienteDTO.ciudad());

        //DATOS DEL PACIENTE
        paciente.setFechaNacimiento(registroPacienteDTO.fechaNacimiento());
        paciente.setAlergias(registroPacienteDTO.alergias());
        paciente.setEps(registroPacienteDTO.eps());
        paciente.setTipoSangre(registroPacienteDTO.tipoSangre());
        paciente.setEstado(Estado.ACTIVO);

        //GURADAMOS AL PACIENTE
        Paciente pacienteNuevo = pacienteRepo.save(paciente);

        return pacienteNuevo.getCodigo();
    }

    private boolean EstaRepetidoCedula(String cedula) {
        return pacienteRepo.findByCedula(cedula) != null;
    }

    private boolean estaRepetidoCorreo(String correo) {
        return pacienteRepo.findByCorreo(correo) != null;
    }

    @Override
    public int editarPerfil(DetallePacienteDTO detallePacienteDTO) throws Exception {

        Optional<Paciente> opcional = pacienteRepo.findById(detallePacienteDTO.codigo());
        if (opcional.isEmpty()){
            throw new Exception("El paciente con el codigo "+ detallePacienteDTO.codigo() +" No existe");
        }

        //BUSCAMOS AL PACIENTE CON EL GET()
        Paciente buscado = opcional.get();

        if (detallePacienteDTO.codigo() == buscado.getCodigo()){
            //DATOS DE LA CUENTA
            buscado.setCorreo(detallePacienteDTO.correo());

            //DATOS DEL USUARIO
            buscado.setNombre(detallePacienteDTO.nombre());
            buscado.setCedula(detallePacienteDTO.cedula());
            buscado.setTelefono(detallePacienteDTO.telefono());
            buscado.setUrlFoto(detallePacienteDTO.urlfoto());
            buscado.setCiudad(detallePacienteDTO.ciudad());

            //DATOS DEL PACIENTE
            buscado.setAlergias(detallePacienteDTO.alergias());
            buscado.setEps(detallePacienteDTO.eps());
            buscado.setTipoSangre(detallePacienteDTO.tipoSangre());
            buscado.setEstado(detallePacienteDTO.estado());
        }

        //como el objeto paciente ya tiene un id, el metodo save() no crea un nuevo registro
        // sino que actualiza el que ya existe
        pacienteRepo.save(buscado);

        return buscado.getCodigo();
    }

    @Override
    public void eliminarCuenta(int codigo) throws Exception {

        //NO SE SI SEA NECESARIO
        Optional<Paciente> pacienteOptional = pacienteRepo.findById(codigo);
        if (pacienteOptional.isEmpty()){
            throw new Exception("No existe un paciente con el codigo: "+ codigo);
        }

        Paciente paciente = pacienteOptional.get();

        if (paciente.getEstado().equals(Estado.ACTIVO)){
            paciente.setEstado(Estado.INACTIVO);
            pacienteRepo.save(paciente);
        }else {
            throw new Exception(("No se que esta pasandos"));
        }

    }

    @Override
    public void enviarLinkRecuperacion(RecupararPasswordPacienteDTO passwordPacienteDTO) throws Exception {

    }

    @Override
    public void cambiarPassword(CambiarPasswordDTO cambiarPasswordDTO) throws Exception {

        Optional<Paciente> opcional = pacienteRepo.findById(cambiarPasswordDTO.codigo());

        if (opcional.isEmpty()){
            throw new Exception("No existe el paciente con el codigo "+ cambiarPasswordDTO.codigo());
        }

        //BUSCAMOS AL PACIENTE CON EL GET()
        Paciente buscado = opcional.get();

        if (cambiarPasswordDTO.correo().equals(buscado.getCorreo())){
            buscado.setPassword(cambiarPasswordDTO.password());
        }

        //como el objeto paciente ya tiene un id, el metodo save() no crea un nuevo registro
        // sino que actualiza el que ya existe
        pacienteRepo.save(buscado);
    }

    //REVISAR
    @Override
    public int agendarCita(AgendarCitaPacienteDTO agendarCitaPacienteDTO) throws Exception {

        Cita c = new Cita();
        Paciente pacientes = new Paciente();

        if (verificarCitaHorarioMedico(agendarCitaPacienteDTO) == false) {//validar que la fecha de la cita sí esté dentro del horario del médico

            if (pacientes.getCitaPacienteList().size() <= 3) {
                c.getPaciente().setCodigo(agendarCitaPacienteDTO.codigoMedico());
                c.getMedico().setCodigo(agendarCitaPacienteDTO.codigoMedico());
                c.setFechaCita(agendarCitaPacienteDTO.fechaCita());
                c.setEstado(EstadoCita.PROGRAMADA);
                c.setFechaCreacion(LocalDateTime.now());
                if (verificarCruceOtraCita(agendarCitaPacienteDTO) == false &&
                        verificarDiaLibremedico(agendarCitaPacienteDTO) == false) {

                    c.setMotivo(agendarCitaPacienteDTO.motivo());
                }else{
                    throw new Exception("El paciente ya tiene otra cita agendada la fehca "+ agendarCitaPacienteDTO.fechaCita());
                }

            }else{
                throw new Exception("El paciente ya tiene más de 3 citas");
            }
        }

        Cita citaNueva = citaRepo.save(c);
        return citaNueva.getCodigo();
    }

    private boolean verificarDiaLibremedico(AgendarCitaPacienteDTO agendarCitaPacienteDTO) {

        List<DiaLibre> medicoList = medicoRepo.buscarDiaLibre(agendarCitaPacienteDTO.codigoMedico(), agendarCitaPacienteDTO.fechaCita());

        if(!medicoList.isEmpty()){
            return true;
        }

        return false;
    }

    private boolean verificarCitaHorarioMedico(AgendarCitaPacienteDTO agendarCitaPacienteDTO) {

        Medico medico = new Medico();

        if (agendarCitaPacienteDTO.fechaCita().equals(medico.getHorarioMedicoList().get(0).getDia())) {
            return true;
        }
        return false;
    }

    private boolean verificarCruceOtraCita(AgendarCitaPacienteDTO agendarCitaPacienteDTO) {

        LocalDateTime fechaCita = null;
        fechaCita = agendarCitaPacienteDTO.fechaCita();

        List <Cita> citasPaciente = citaRepo.obtenerCitasFecha(agendarCitaPacienteDTO.codigoPaciente(), fechaCita.toLocalDate());

        if(!citasPaciente.isEmpty()){
            return  true;
        }


        return false;
    }

    @Override
    public PQRS crearPQRS(CrearPQRSDTO crearPqrsdto)throws Exception {

        LocalDateTime fecha = LocalDateTime.now();
        //codigo es el codigo del paciente
        int codigoPaciente = crearPqrsdto.codigo();
        String tipoPqrs = crearPqrsdto.tipo();
        String motivoPqrs = crearPqrsdto.motivo();
        PQRS pqrs = new PQRS();

        List<PQRS> pqrsPaciente = pqrsRepo.listarPqrsDePaciente(codigoPaciente);

        if (pqrsPaciente.size() <= 3) {

            pqrs.setEstado(EstadoPQRS.EN_PROCESO);
            pqrs.setMotivo(motivoPqrs);
            pqrs.setFechaCreacion(fecha);
            pqrs.setTipo(tipoPqrs);
            PQRS saved =  pqrsRepo.save(pqrs);

            if (saved == null){
                throw new Exception("No se a logrado crear el PQRS");
            }

        }else{
            throw new Exception("El paciente ya tiene 3 PQRS");
        }

        return pqrs;
    }

    @Override
    public List<ItemPQRSDTO> listarPQRSPaciente(int codigo) throws Exception {

        List<PQRS> listaPqrs = pqrsRepo.listarPqrsDePaciente(codigo);
        List<ItemPQRSDTO> respuesta = new ArrayList<>();

        for(PQRS p: listaPqrs){
            respuesta.add(new ItemPQRSDTO(
                    p.getCodigo(),
                    p.getEstado(),
                    p.getMotivo(),
                    p.getFechaCreacion()));
        }

        return respuesta;
    }
    @Override
    public DetallePQRSDTO verDetallePQRS(int codigo) throws Exception {
        Optional<PQRS> opcional = pqrsRepo.findById(codigo);

        if (opcional.isEmpty()){
            throw new Exception("No existe un PQRS con el codigo "+ codigo);
        }

        PQRS buscando = opcional.get();
        List<Mensaje> mensajes = mensajeRepo.findAllByCodigoPqrsCodigo(codigo);

        if(buscando.getCita().getMedico() == null){
            throw new Exception("El medico es nulo");
        }

        return new DetallePQRSDTO(
                buscando.getCodigo(),
                buscando.getEstado(),
                buscando.getMotivo(),
                buscando.getCita().getPaciente().getNombre(),
                buscando.getCita().getMedico().getNombre(),
                buscando.getCita().getMedico().getEspecialidad(),
                buscando.getFechaCreacion(),
                convertirRespuestaDTO(mensajes));
    }

    private List<RespuestaDTO> convertirRespuestaDTO(List<Mensaje> mensajes) {

        return mensajes.stream().map(m -> new RespuestaDTO(
                m.getCodigo(),
                m.getContenido(),
                m.getCuenta().getCorreo(),
                m.getFecha()
        )).toList();
    }

    @Override
    public int responderPQRS(RegistroRespuestaDTO registroRespuestaDTO) throws Exception {

        Optional<PQRS> opcionalPQRS = pqrsRepo.findById(registroRespuestaDTO.codigoPQRS());

        if (opcionalPQRS.isEmpty()){
            throw new Exception("No existe una cuenta con el codigo "+registroRespuestaDTO.codigoPQRS());
        }

        Optional<Cuenta> opcionalCuenta = cuentaRepo.findById(registroRespuestaDTO.codigoCuenta());

        if (opcionalPQRS.isEmpty()){
            throw new Exception("No existe una cuenta con el codigo "+registroRespuestaDTO.codigoCuenta());
        }

        Mensaje mensajeNuevo = new Mensaje();
        mensajeNuevo.setCodigoPqrs(opcionalPQRS.get());
        mensajeNuevo.setFecha(LocalDateTime.now());
        mensajeNuevo.setCuenta(opcionalCuenta.get());
        mensajeNuevo.setContenido(registroRespuestaDTO.mensaje());

        Mensaje respuesta = mensajeRepo.save(mensajeNuevo);

        return respuesta.getCodigo();
    }


    @Override
    public List<ItemCitaPendientePacienteDTO> listarCitasPaciente(int codigo) throws Exception {

        List<Cita> historial = citaRepo.obtenerHistorialPaciente(codigo);
        List<ItemCitaPendientePacienteDTO> respuesta = new ArrayList<>();
        if(historial.isEmpty()){
            throw new Exception("No ha tenido ninguna cita");
        }
        //Hacemos un mapeo de cada uno de los objetos de tipo Paciente a tipo objeto ItempacienteDTO
        for (Cita c: historial){
            respuesta.add(new ItemCitaPendientePacienteDTO(
                    c.getCodigo(),
                    c.getMedico().getCedula(),
                    c.getMedico().getNombre(),
                    c.getFechaCita(),
                    c.getMedico().getEspecialidad(),
                    c.getEstado()));
        }

        return respuesta;
    }

    @Override
    public List<ItemCitaPendientePacienteDTO> filtrarCitasPorFecha(FiltroBusquedaDTO filtroBusquedaDTO) throws Exception {

        List<Cita> citas = citaRepo.obtenerCitasFecha(filtroBusquedaDTO.codigoPaciente(), filtroBusquedaDTO.fecha());
        List<ItemCitaPendientePacienteDTO> respuesta = new ArrayList<>();

        if (citas.isEmpty()){
            throw new Exception("No existe cita creadas");
        }

        for (Cita c: citas){
            respuesta.add(new ItemCitaPendientePacienteDTO(
                c.getCodigo(),
                c.getMedico().getCedula(),
                c.getMedico().getNombre(),
                c.getFechaCita(),
                c.getMedico().getEspecialidad(),
                c.getEstado()));
        }

        return respuesta;
    }

    @Override
    public List<ItemCitaPendientePacienteDTO> filtrarCitasPorMedico(FiltroBusquedaDTO filtroBusquedaDTO) throws Exception {

        List<Cita> citas = citaRepo.obtenerCitasNombreMedico(filtroBusquedaDTO.codigoPaciente(), filtroBusquedaDTO.nombreMedico());
        List<ItemCitaPendientePacienteDTO> respuesta = new ArrayList<>();

        if (citas.isEmpty()){
            throw new Exception("No existe cita creadas");
        }
    //organizar
        for (Cita c: citas){
            respuesta.add(new ItemCitaPendientePacienteDTO(
                    c.getCodigo(),
                    c.getMedico().getCedula(),
                    c.getMedico().getNombre(),
                    c.getFechaCita(),
                    c.getMedico().getEspecialidad(),
                    c.getEstado()));
        }

        return respuesta;
    }

    @Override
    public List<ItemCitaPendientePacienteDTO> listarMedicosEspecialidad(MedicoEspecialidadDTO especialidadDTO) throws Exception{
        List<Cita> citas = citaRepo.listarMedicosEspecialidad(especialidadDTO.codigoPaciente(), especialidadDTO.especialidad());
        List<ItemCitaPendientePacienteDTO> respuesta = new ArrayList<>();

        if (citas.isEmpty()){
            throw new Exception("No existe cita creadas");
        }
        //organizar
        for (Cita c: citas){
            respuesta.add(new ItemCitaPendientePacienteDTO(
                    c.getCodigo(),
                    c.getMedico().getCedula(),
                    c.getMedico().getNombre(),
                    c.getFechaCita(),
                    c.getMedico().getEspecialidad(),
                    c.getEstado()));
        }

        return respuesta;
    }

    @Override
    public DetallePacienteDTO verDetallePaciente(int codigo) throws Exception {

        Optional<Paciente> opcional = pacienteRepo.findById(codigo);

        if (opcional.isEmpty()){
            throw new Exception("No existe el paciente con el codigo "+ codigo);
        }

        //PARA OBTENER EL PACIENTE CON EL CODIOGO
        Paciente buscado = opcional.get();

        //PREGUNTAR SI ESTO SIRVE
        buscado.toString();

        //Hacemos un mapeo de un objeto a tipo Paciente a un objeto de tipo DetallePacienteDTO
        return new DetallePacienteDTO(
                buscado.getCodigo(),
                buscado.getCorreo(),
                buscado.getNombre(),
                buscado.getCedula(),
                buscado.getTelefono(),
                buscado.getUrlFoto(),
                buscado.getFechaNacimiento(),
                buscado.getAlergias(),
                buscado.getCiudad(),
                buscado.getEps(),
                buscado.getTipoSangre(),
                buscado.getEstado());
    }

}
