package co.edu.uniquindio.proyecto.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
@requestbody
public record TokenDTO(
        @NotNull
        String tocken
) {
}
