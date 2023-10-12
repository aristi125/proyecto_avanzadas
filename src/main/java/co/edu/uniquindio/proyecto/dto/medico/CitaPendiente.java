package co.edu.uniquindio.proyecto.dto.medico;

import java.time.LocalDateTime;

public record CitaPendiente(
        String nombrePaciente,
        String cedula,
        LocalDateTime ProximafechasCita

) {
}
