package co.edu.uniquindio.proyecto.dto;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record CrearPQRSDTO(
        @NotNull
        int codigo,
        @NotNull
        @Length(max = 200)
        String tipo,
        @NotNull
        @Length(max = 200)
        String motivo
) {
}
