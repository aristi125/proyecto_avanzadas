package co.edu.uniquindio.proyecto.dto.admin;

import java.time.LocalDateTime;
import java.time.LocalTime;

public record HorarioDTO(
        String dia,
        LocalTime horaIncio,
        LocalTime horaSalida
) {
}
