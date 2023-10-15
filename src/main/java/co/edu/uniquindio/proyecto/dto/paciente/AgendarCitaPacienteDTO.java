package co.edu.uniquindio.proyecto.dto.paciente;

import co.edu.uniquindio.proyecto.modelo.enumeracion.Especialidad;

import java.time.LocalDateTime;

public record AgendarCitaPacienteDTO(
        int codigo,
        String nombreMedico,
        String cedulaMedico,
        String motivo,
        LocalDateTime fechaCita,
        Especialidad especialidad

) {
}
