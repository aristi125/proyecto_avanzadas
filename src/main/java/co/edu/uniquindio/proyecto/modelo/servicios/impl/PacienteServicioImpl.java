package co.edu.uniquindio.proyecto.modelo.servicios.impl;

import co.edu.uniquindio.proyecto.dto.DetallePQRSDTO;
import co.edu.uniquindio.proyecto.dto.ItemPQRSDTO;
import co.edu.uniquindio.proyecto.dto.RegistroRespuestaDTO;
import co.edu.uniquindio.proyecto.dto.RespuestaDTO;
import co.edu.uniquindio.proyecto.dto.paciente.*;
import co.edu.uniquindio.proyecto.modelo.entidades.*;
import co.edu.uniquindio.proyecto.modelo.enumeracion.EstadoCita;
import co.edu.uniquindio.proyecto.modelo.enumeracion.EstadoPQRS;
import co.edu.uniquindio.proyecto.modelo.repositorios.*;
import co.edu.uniquindio.proyecto.modelo.servicios.interfaces.PacienteServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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
    public int editarPerfil(DetatellePacienteDTO detatellePacienteDTO) throws Exception {

        Optional<Paciente> opcional = pacienteRepo.findById(detatellePacienteDTO.codigo());
        if (opcional.isEmpty()){
            throw new Exception("El paciente con el codigo "+ detatellePacienteDTO.codigo() +" No existe");
        }

        //BUSCAMOS AL PACIENTE CON EL GET()
        Paciente buscado = opcional.get();

        if (detatellePacienteDTO.codigo() == buscado.getCodigo()){
            //DATOS DE LA CUENTA
            buscado.setCorreo(detatellePacienteDTO.correo());

            //DATOS DEL USUARIO
            buscado.setNombre(detatellePacienteDTO.nombre());
            buscado.setCedula(detatellePacienteDTO.cedula());
            buscado.setTelefono(detatellePacienteDTO.telefono());
            buscado.setUrlFoto(detatellePacienteDTO.urlfoto());
            buscado.setCiudad(detatellePacienteDTO.ciudad());

            //DATOS DEL PACIENTE
            buscado.setAlergias(detatellePacienteDTO.alergias());
            buscado.setEps(detatellePacienteDTO.eps());
            buscado.setTipoSangre(detatellePacienteDTO.tipoSangre());
        }

        //como el objeto paciente ya tiene un id, el metodo save() no crea un nuevo registro
        // sino que actualiza el que ya existe
        pacienteRepo.save(buscado);

        return buscado.getCodigo();
    }

    @Override
    public void eliminarCuenta(int codigo) throws Exception {

        Optional<Paciente> opcional = pacienteRepo.findById(codigo);

        if (opcional.isEmpty()){
            throw new Exception("No existe un paciente con el codigo: "+ codigo);
        }

        pacienteRepo.delete(opcional.get());
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

    @Override
    public int agendarCita(AgendarCitaPacienteDTO agendarCitaPacienteDTO) throws Exception {

        Paciente paciente = pacienteRepo.findByCedula(agendarCitaPacienteDTO.cedulaPaciente());
        Medico medico = medicoRepo.findByCedula(agendarCitaPacienteDTO.cedulaMedico());

        if (!(agendarCitaPacienteDTO.cedulaPaciente().equals(paciente.getCedula()))){
            throw new Exception("No existe un paciente con el codigo " + agendarCitaPacienteDTO.cedulaPaciente());
        }

        if (!(medico.getCedula().equals(agendarCitaPacienteDTO.cedulaMedico()))){
            throw new Exception("No existe un medico con el codigo "+ agendarCitaPacienteDTO.cedulaMedico());
        }

        Cita c = new Cita();
        Paciente pacientes = new Paciente();

        if (agendarCitaPacienteDTO.cedulaPaciente().equals(pacientes.getCedula()) &&
                verificarCitaHorarioMedico(agendarCitaPacienteDTO) == false) {//validar que la fecha de la cita sí esté dentro del horario del médico

            if (pacientes.getCitaPacienteList().size() <= 3) {

                c.setPaciente(paciente);
                c.setMedico(medico);
                c.setFechaCita(agendarCitaPacienteDTO.fechaCita());
                c.setEstado(EstadoCita.PROGRAMADA);
                c.setFechaCreacion(LocalDateTime.now());

                //validar que la cita no se cruce con otra cita
                //validar que el día elegido para la cita no sea un día libre del médico
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

        List<Medico> medicoList = new ArrayList<>();
        //primera forma que se me ocurrio
        LocalDateTime fechaLibre = null;

        for (Medico m: medicoList){
            fechaLibre = LocalDateTime.from(m.getDia_libreList().get(0).getDia());
        }

        if (agendarCitaPacienteDTO.fechaCita().isEqual(fechaLibre)){
            return true;
        }else {
            return false;
        }
        //segunda forma
//        Medico medico = new Medico();
//        if (agendarCitaPacienteDTO.fechaCita().equals(medico.getHorarioMedicoList().get(0).getDia())) {
//            return false;
//        }else {
//            return true;
//        }
    }

    private boolean verificarCitaHorarioMedico(AgendarCitaPacienteDTO agendarCitaPacienteDTO) {

        Medico medico = new Medico();

        if (agendarCitaPacienteDTO.fechaCita().equals(medico.getHorarioMedicoList().get(0).getDia())) {
            return true;
        }
        return false;
    }

    private boolean verificarCruceOtraCita(AgendarCitaPacienteDTO agendarCitaPacienteDTO) {

        Paciente paciente = new Paciente();
        List<Paciente> pacienteList = new ArrayList<>();
        LocalDateTime cruceCita = null;

        for (Paciente p: pacienteList){
             cruceCita = p.getCitaPacienteList().get(0).getFechaCita();
        }

        if (agendarCitaPacienteDTO.fechaCita().isEqual(cruceCita)){
            return true;
        }

        return false;
//        if (agendarCitaPacienteDTO.fechaCita().equals(paciente.getCitaPacienteList().get(0).getFechaCita())){
//            return false;
//        }
//        return true;
    }

    @Override
    public PQRS crearPQRS(int codigo, String tipo, String motivo)throws Exception {

        LocalDateTime fecha = LocalDateTime.now();
        //codigo es el codigo del paciente
        int codigoPaciente = codigo;
        String tipoPqrs = tipo, motivoPqrs = motivo;
        PQRS pqrs = null;

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
    public List<ItemPQRSDTO> listarPQRSPaciente() throws Exception {

        List<PQRS> listaPqrs = pqrsRepo.findAll();
        List<ItemPQRSDTO> respuesta = new ArrayList<>();

        for(PQRS p: listaPqrs){
            respuesta.add(new ItemPQRSDTO(
                    p.getCodigo(),
                    p.getEstado(),
                    p.getMotivo(),
                    p.getFechaCreacion(),
                    p.getCita().getPaciente().getNombre()));
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

        List<Cita> citas = citaRepo.findAll();
        List<ItemCitaPendientePacienteDTO> respuesta = new ArrayList<>();

        if (citas.isEmpty()){
            throw new Exception("No existe citas creadas");
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
    public List<ItemCitaPendientePacienteDTO> filtrarCitasPorFecha(ItemCitaPendientePacienteDTO fechaPacienteDTO) throws Exception {

        Paciente opcional = pacienteRepo.findByCitaPacienteListFechaCita(fechaPacienteDTO.fechaCita());
        List<Cita> citas = citaRepo.findAll();
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
    public List<ItemCitaPendientePacienteDTO> filtrarCitasPorMedico(ItemCitaPendientePacienteDTO pendientePacienteDTO) throws Exception {
        Paciente opcional = pacienteRepo.findByCitaPacienteListMedicoNombre(pendientePacienteDTO.nombreMedico());
        List<Cita> citas = citaRepo.findAll();
        List<ItemCitaPendientePacienteDTO> respuesta = new ArrayList<>();

        if (citas.isEmpty()){
            throw new Exception("No existe cita creadas");
        }
    //organizar
        if (pendientePacienteDTO.nombreMedico().equals(opcional.getNombre())) {
            for (Cita c: citas){
                respuesta.add(new ItemCitaPendientePacienteDTO(
                        c.getCodigo(),
                        c.getMedico().getCedula(),
                        c.getMedico().getNombre(),
                        c.getFechaCita(),
                        c.getMedico().getEspecialidad(),
                        c.getEstado()));
            }
        }
        return respuesta;
    }

    @Override
    public DetatellePacienteDTO verDetallePaciente(int codigo) throws Exception {

        Optional<Paciente> opcional = pacienteRepo.findById(codigo);

        if (opcional.isEmpty()){
            throw new Exception("No existe el paciente con el codigo "+ codigo);
        }

        //PARA OBTENER EL PACIENTE CON EL CODIOGO
        Paciente buscado = opcional.get();

        //PREGUNTAR SI ESTO SIRVE
        buscado.toString();

        //Hacemos un mapeo de un objeto a tipo Paciente a un objeto de tipo DetallePacienteDTO
        return new DetatellePacienteDTO(
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
                buscado.getTipoSangre());
    }

    @Override
    public List<ItemPacienteDTO> verHistorialCita() throws Exception {

        List<Cita> historial = citaRepo.obtenerHistorialPaciente(1);
        List<Paciente> pacientes = new ArrayList<>();
        List<ItemPacienteDTO> respuesta = new ArrayList<>();

        //Hacemos un mapeo de cada uno de los objetos de tipo Paciente a tipo objeto ItempacienteDTO
        for (Paciente p: pacientes){
            respuesta.add(new ItemPacienteDTO(
                    p.getCodigo(),
                    p.getNombre(),
                    p.getCedula(),
                    p.getCiudad()));
        }

        return respuesta;
    }
}
