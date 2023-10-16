package co.edu.uniquindio.proyecto.dto.paciente;

import co.edu.uniquindio.proyecto.dto.admin.HorarioDTO;
import co.edu.uniquindio.proyecto.modelo.enumeracion.Especialidad;

import java.time.LocalDateTime;
import java.util.List;

public record AgendarCitaPacienteDTO(
        String nombreMedico,
        String nombrePaciente,
        String cedulaMedico,
        String cedulaPaciente,
        String motivo,
        LocalDateTime fechaCita,
        Especialidad especialidad,
        String horarios

) {
}
