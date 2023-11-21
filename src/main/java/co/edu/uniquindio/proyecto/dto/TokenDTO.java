package co.edu.uniquindio.proyecto.dto;

import jakarta.validation.constraints.NotNull;

public record TokenDTO(
        @NotNull
        String token
) {
}
