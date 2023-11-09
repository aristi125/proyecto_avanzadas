package co.edu.uniquindio.proyecto.modelo.servicios.interfaces;

import co.edu.uniquindio.proyecto.dto.*;
import co.edu.uniquindio.proyecto.dto.paciente.*;
import co.edu.uniquindio.proyecto.modelo.entidades.PQRS;

import java.util.List;

public interface PacienteServicio {
    int registrarse(RegistroPacienteDTO registroPacienteDTO) throws Exception;

    int editarPerfil(DetallePacienteDTO detallePacienteDTO) throws Exception;

    void eliminarCuenta(int codigo) throws Exception;

    //NO SE SI LO UTILICEMOS
    void enviarLinkRecuperacion(RecupararPasswordPacienteDTO passwordPacienteDTO) throws Exception;

    void cambiarPassword(CambiarPasswordDTO cambiarPasswordDTO) throws Exception;

    int agendarCita(AgendarCitaPacienteDTO agendarCitaPacienteDTO) throws Exception;

    PQRS crearPQRS(CrearPQRSDTO crearPqrsdto) throws Exception;

    List<ItemPQRSDTO> listarPQRSPaciente( int codigo) throws Exception;
    DetallePQRSDTO verDetallePQRS(int codigo) throws Exception;
    int responderPQRS(RegistroRespuestaDTO registroRespuestaDTO) throws Exception;

    List<ItemCitaPendientePacienteDTO> listarCitasPaciente(int codigo) throws Exception;

    List<ItemCitaPendientePacienteDTO> filtrarCitasPorFecha(FiltroBusquedaDTO filtroBusquedaDTO) throws Exception;

    List<ItemCitaPendientePacienteDTO> filtrarCitasPorMedico(FiltroBusquedaDTO filtroBusquedaDTO) throws Exception;
    List<ItemCitaPendientePacienteDTO> listarMedicosEspecialidad(MedicoEspecialidadDTO especialidadDTO) throws Exception;
    DetallePacienteDTO verDetallePaciente(int codigo) throws Exception;

}
