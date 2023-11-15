package co.edu.uniquindio.proyecto.dto;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record ValidacionDTO(
        @NotNull
        @Length(max = 200)
        String campo,
        @NotNull
        @Length(max = 200)
        String error
) {
}
