package co.edu.uniquindio.proyecto.dto;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record EmailDTO(
        @NotNull
        @Length(max = 200)
        String asunto,
        @NotNull
        @Length(max = 200)
        String cuerpo,
        @NotNull
        @Length(max = 200)
        String destinatario
) {
}
