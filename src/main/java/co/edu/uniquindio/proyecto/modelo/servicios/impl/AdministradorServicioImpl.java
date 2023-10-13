package co.edu.uniquindio.proyecto.modelo.servicios.impl;

import co.edu.uniquindio.proyecto.dto.*;
import co.edu.uniquindio.proyecto.dto.admin.*;
import co.edu.uniquindio.proyecto.modelo.entidades.*;
import co.edu.uniquindio.proyecto.modelo.enumeracion.Estado;
import co.edu.uniquindio.proyecto.modelo.enumeracion.EstadoPQRS;
import co.edu.uniquindio.proyecto.modelo.repositorios.*;
import co.edu.uniquindio.proyecto.modelo.servicios.interfaces.AdministradorServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor //CREA EL CONSTRUTOR DE TODOS LOS METODOS
public class AdministradorServicioImpl implements AdministradorServicio {

    private final MedicoRepo medicoRepo;

    private final PQRSRepo pqrsRepo;

    private final CuentaRepo cuentaRepo;

    private final MensajeRepo mensajeRepo;

    private final CitaRepo citaRepo;

    private final HorarioRepo horarioRepo;
    //=======================================================
    @Override
    public int crearMedico(RegistroMedicoDTO medicoDTO) throws Exception {
        if(estaRepetidoCorreo(medicoDTO.correo())){
            throw new Exception("El correo " + medicoDTO.correo()+" esta en uso");
        }
        if (estaRepetidoCedula(medicoDTO.cedula())){
            throw new Exception("La cedula "+ medicoDTO.cedula()+" ya se encuetnra registrada");
        }
        //=====================================================

        //SE CREA UNA INSTANCIA PARA GUARDARLO
        Medico medico = new Medico();
        //LE PASAMOS LOS PARAMETROS
        //medico.setFechaRegistro(LocalDateTime.now()); preguntar
        //medico.setEstado(Estado.ACTIVO);
        medico.setNombre(medicoDTO.nombre());
        medico.setCedula(medicoDTO.cedula());
        medico.setTelefono(medicoDTO.telefono());
        medico.setUrlFoto(medicoDTO.urlFoto());
        medico.setCiudad(medicoDTO.ciudad());
        medico.setEspecialidad(medicoDTO.especialidad());
        //SON METODOS DE LA CUENTA
        medico.setCorreo(medicoDTO.correo());
        medico.setPassword(medicoDTO.password());
        medico.setEstadoUsuario(Estado.ACTIVO);

        Medico medicoNuevo= medicoRepo.save(medico);
        asignarHorariosMedico(medicoNuevo,medicoDTO.horarios() );
        return medicoNuevo.getCodigo();
    }

    /**
     * METODO PARA ASIGNAR UN HORARIO AL MEDICO
     * @param medicoNuevo
     * @param horarios
     */
    private void asignarHorariosMedico(Medico medicoNuevo, List<HorarioDTO> horarios) {
        for (HorarioDTO h : horarios){
            HorarioMedico hm = new HorarioMedico();
            hm.setDia(h.dia());
            hm.setHoraInicio(h.horaIncio());
            hm.setHoraFin(h.horaSalida());

            //GUARDAMOS LOS HORARIOS ASIGNADOS AL MEDICO
            horarioRepo.save(hm);
        }
    }

    private boolean estaRepetidoCedula(String cedula) {
        return medicoRepo.findByCedula(cedula) != null;
    }

    private boolean estaRepetidoCorreo(String correo) {
        return medicoRepo.findByCorreo(correo) != null;
    }

    @Override
    public int actualizarMedico(DetalleMedicoDTO medicoDTO) throws Exception {
        Optional<Medico> opcional = medicoRepo.findById(medicoDTO.codigo());
        if (opcional.isEmpty()){
            throw new Exception("No exisite un medico con el codigo "+ medicoDTO.codigo());
        }

        Medico buscado = opcional.get();

        buscado.setNombre(medicoDTO.nombre());
        buscado.setCedula(medicoDTO.cedula());
        buscado.setTelefono(medicoDTO.telefono());
        buscado.setEspecialidad(medicoDTO.especialidad());
        buscado.setUrlFoto(medicoDTO.urlFoto());
        //preguntar
        buscado.setCiudad(medicoDTO.ciudad());

        //guarda el buscado y actualiza los datos
        medicoRepo.save(buscado);
        return buscado.getCodigo();
    }

    @Override
    public void eliminarMedico(int codigo) throws Exception {
        Optional<Medico> opcional= medicoRepo.findById(codigo);
        if(opcional.isEmpty()){
            throw new Exception("no existe un medico con el codigo "+codigo);
        }
        Medico buscado = opcional.get();
        buscado.setEstadoUsuario(Estado.INACTIVO);
        //para guardar los datos
        medicoRepo.save(buscado);
    }

    @Override
    public List<ItemMedicoDTO> listarMedico() throws Exception {
        List<Medico> medicos = medicoRepo.findAll();
        if (medicos.isEmpty()){
            throw new Exception("No hay medicos registrados");
        }
        List<ItemMedicoDTO> respuesta = new ArrayList<>();
        for (Medico m: medicos){
            respuesta.add(new ItemMedicoDTO(
                    m.getCodigo(),
                    m.getCedula(),
                    m.getNombre(),
                    m.getUrlFoto(),
                    m.getEspecialidad()
            ));
        }
        return respuesta;
    }

    @Override
    public DetalleMedicoDTO obtenerMedico(int codigo) throws Exception {
        Optional<Medico> opcional = medicoRepo.findById(codigo);
        if (opcional.isEmpty()){
            throw new Exception("No existe un médico con el código "+ codigo);
        }
        Medico buscado = opcional.get();
        List<HorarioMedico> horarios = horarioRepo.findAllByCodigo(codigo);
        List<HorarioDTO> horariosDTO = new ArrayList<>();
        for(HorarioMedico h: horarios){
            horariosDTO.add( new HorarioDTO(
                    h.getDia(),
                    h.getHoraInicio(),
                    h.getHoraFin()
            ));
        }
        return new DetalleMedicoDTO(
                buscado.getCodigo(),
                buscado.getNombre(),
                buscado.getCedula(),
                buscado.getCiudad(),
                buscado.getEspecialidad(),
                buscado.getTelefono(),
                buscado.getCorreo(),
                buscado.getUrlFoto(),
                horariosDTO
        );
    }

    @Override
    public List<ItemPQRSDTO> listarPQRS() throws Exception {
        List<PQRS> listaPqrs = pqrsRepo.findAll();
        List<ItemPQRSDTO> respuesta = new ArrayList<>();
        for(PQRS p: listaPqrs){
            respuesta.add(new ItemPQRSDTO(
                    p.getCodigo(),
                    p.getEstado(),
                    p.getMotivo(),
                    p.getFechaCreacion(),
                    p.getCita().getPaciente().getNombre()
            ));
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

        return new DetallePQRSDTO(
                buscando.getCodigo(),
                buscando.getEstado(),
                buscando.getMotivo(),
                buscando.getCita().getPaciente().getNombre(),
                buscando.getCita().getMedico().getNombre(),
                buscando.getCita().getMedico().getEspecialidad(),
                buscando.getFechaCreacion(),
                convertirRespuestaDTO(mensajes)

        );
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
    public void cambiarEstadoPQRS(int codigoPQRS, EstadoPQRS estadoPQRS) throws Exception {
        Optional<PQRS> opcional = pqrsRepo.findById(codigoPQRS);
        if (opcional.isEmpty()){
            throw  new Exception("No existe un PQRS con el codigo "+codigoPQRS);
        }
        PQRS pqrs = opcional.get();
        pqrs.setEstado(estadoPQRS);

        pqrsRepo.save(pqrs);
    }

    @Override
    public List<ItemCitaDTOAdmin> listarCitas() throws Exception {
        List<Cita> citas = citaRepo.findAll();
        List<ItemCitaDTOAdmin> respuesta = new ArrayList<>();
        if (citas.isEmpty()){
            throw new Exception("No existe citas creadas");
        }

        for(Cita c: citas){
            respuesta.add(new ItemCitaDTOAdmin(
                    c.getCodigo(),
                    c.getPaciente().getCedula(),
                    c.getPaciente().getNombre(),
                    c.getMedico().getNombre(),
                    c.getMedico().getEspecialidad(),
                    c.getEstado(),
                    c.getFechaCita()
            ));
        }
        return respuesta;
    }
}
