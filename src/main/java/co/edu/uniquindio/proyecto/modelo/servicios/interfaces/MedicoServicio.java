package co.edu.uniquindio.proyecto.modelo.servicios.interfaces;

import co.edu.uniquindio.proyecto.dto.medico.*;
import co.edu.uniquindio.proyecto.modelo.entidades.Cita;
import co.edu.uniquindio.proyecto.modelo.enumeracion.EstadoCita;

import java.util.List;

public interface MedicoServicio {
    List<ItemCitasPendienteDTOMedico> listarCitasPendientes(int codigo) throws Exception;
    int atenderCitas(AtenderConsultaPacienteDTO atenderConsultaPacienteDTO) throws Exception;

    List<HistorialPacienteDTO> listasUnaCitasPaciente(int codigo) throws Exception; //historial medico
    int agendarDiaLibre(DiaLibreDTO diaLibreDTO) throws Exception;
    //TENGO DUDAS SI ESTA BIEN
    List<ItemCitasActualDTOMedico> listarTodasCitasPacientes(int codigo) throws Exception;

}
