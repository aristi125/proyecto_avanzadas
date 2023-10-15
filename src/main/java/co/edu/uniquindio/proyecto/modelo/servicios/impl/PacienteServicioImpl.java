package co.edu.uniquindio.proyecto.modelo.servicios.impl;

import co.edu.uniquindio.proyecto.dto.DetallePQRSDTO;
import co.edu.uniquindio.proyecto.dto.ItemPQRSDTO;
import co.edu.uniquindio.proyecto.dto.RegistroRespuestaDTO;
import co.edu.uniquindio.proyecto.dto.paciente.*;
import co.edu.uniquindio.proyecto.modelo.entidades.Paciente;
import co.edu.uniquindio.proyecto.modelo.repositorios.PacienteRepo;
import co.edu.uniquindio.proyecto.modelo.servicios.interfaces.PacienteServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor // CREA EL CONSTRUCTOR DE TODOS LOS METODOS
public class PacienteServicioImpl implements PacienteServicio {
    @Autowired
    private final PacienteRepo pacienteRepo;
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
        paciente.setCorreo(registroPacienteDTO.correo());
        paciente.setPassword(registroPacienteDTO.password());

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
    public void cambiarPassword() throws Exception {

    }

    @Override
    public void agendarCita(AgendarCitaPacienteDTO agendarCitaPacienteDTO) throws Exception {

    }

    @Override
    public DetallePQRSDTO crearPQRS(int codigo) {
        return null;
    }

    @Override
    public List<ItemPQRSDTO> listarPQRSPaciente(int codigo) throws Exception {
        return null;
    }

    @Override
    public int responderPQRS(RegistroRespuestaDTO registroRespuestaDTO) throws Exception {
        return 0;
    }

    @Override
    public List<ItemCitaPendientePacienteDTO> listarCitasPaciente(int codigo) throws Exception {
        return null;
    }

    @Override
    public void filtrarCitasPorFecha() throws Exception {

    }

    @Override
    public void filtrarCitasPorMedico() throws Exception {

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
