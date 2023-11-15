package co.edu.uniquindio.proyecto.dto;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record LoginDTO(
        @NotNull
        @Length(max = 100)
        String correo,
        @NotNull
        @Length(max = 200)
        String password
) {
}
