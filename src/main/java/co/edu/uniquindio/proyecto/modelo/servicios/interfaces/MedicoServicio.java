package co.edu.uniquindio.proyecto.modelo.servicios.interfaces;

import co.edu.uniquindio.proyecto.dto.medico.AtenderConsultaPacienteDTO;
import co.edu.uniquindio.proyecto.dto.medico.DiaLibreDTO;
import co.edu.uniquindio.proyecto.dto.medico.ItemCitasActualDTOMedico;
import co.edu.uniquindio.proyecto.dto.medico.ItemCitasPendienteDTOMedico;
import co.edu.uniquindio.proyecto.modelo.entidades.Cita;
import co.edu.uniquindio.proyecto.modelo.enumeracion.EstadoCita;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MedicoServicio {
    List<ItemCitasPendienteDTOMedico> listarCitasPendientes(int codigo) throws Exception;
    int atenderCitas(AtenderConsultaPacienteDTO atenderConsultaPacienteDTO) throws Exception;

    List<ItemCitasPendienteDTOMedico> listasCitasPaciente() throws Exception; //historial medico
    void agendarDiaLibre(DiaLibreDTO diaLibreDTO) throws Exception;
    //TENGO DUDAS SI ESTA BIEN
    List<Cita> listarCitasPorEstado(EstadoCita estado) throws Exception;

}
