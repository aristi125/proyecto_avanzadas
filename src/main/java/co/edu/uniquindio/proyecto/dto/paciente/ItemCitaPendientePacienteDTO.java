package co.edu.uniquindio.proyecto.dto.paciente;

import co.edu.uniquindio.proyecto.modelo.enumeracion.Especialidad;
import co.edu.uniquindio.proyecto.modelo.enumeracion.EstadoCita;

import java.time.LocalDateTime;

public record ItemCitaPendientePacienteDTO(
        int codigoCita,
        String cedulaMedico,
        String nombreMedico,
        LocalDateTime fechaCita,
        Especialidad especialidad,
        EstadoCita estadoCita
) {
}
