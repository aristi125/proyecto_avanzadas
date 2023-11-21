package co.edu.uniquindio.proyecto.dto.admin;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.time.LocalTime;

public record   HorarioDTO(

        String hora
) {
}
