package co.edu.uniquindio.proyecto.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

public record RespuestaDTO(
        @Positive
        int codigoMensaje,
        @NotNull
        @Length(max = 200)
        String mensaje,
        @NotNull
        @Length(max = 200)
        String nombreUsuario,
        @NotNull
        LocalDateTime fecha
) {
}
