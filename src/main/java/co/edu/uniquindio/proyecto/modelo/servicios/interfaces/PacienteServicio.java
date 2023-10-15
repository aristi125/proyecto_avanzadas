package co.edu.uniquindio.proyecto.modelo.servicios.interfaces;

import co.edu.uniquindio.proyecto.dto.DetallePQRSDTO;
import co.edu.uniquindio.proyecto.dto.ItemPQRSDTO;
import co.edu.uniquindio.proyecto.dto.RegistroRespuestaDTO;
import co.edu.uniquindio.proyecto.dto.paciente.*;

import java.util.List;

public interface PacienteServicio {
    int registrarse(RegistroPacienteDTO registroPacienteDTO) throws Exception;

    int editarPerfil(DetatellePacienteDTO detatellePacienteDTO) throws Exception;

    void eliminarCuenta(int codigo) throws Exception;

    void enviarLinkRecuperacion(RecupararPasswordPacienteDTO passwordPacienteDTO) throws Exception;

    void cambiarPassword() throws Exception;

    void agendarCita(AgendarCitaPacienteDTO agendarCitaPacienteDTO) throws Exception;

    DetallePQRSDTO crearPQRS(int codigo);

    List<ItemPQRSDTO> listarPQRSPaciente(int codigo) throws Exception;

    int responderPQRS(RegistroRespuestaDTO registroRespuestaDTO) throws Exception;

    List<ItemCitaPendientePacienteDTO> listarCitasPaciente(int codigo) throws Exception;

    void filtrarCitasPorFecha() throws Exception;

    void filtrarCitasPorMedico() throws Exception;
    DetatellePacienteDTO verDetallePaciente(int codigo) throws Exception;

    List<ItemPacienteDTO> verHistorialCita() throws Exception;
}
