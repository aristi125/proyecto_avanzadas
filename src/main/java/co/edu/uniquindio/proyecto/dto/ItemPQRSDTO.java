package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.modelo.enumeracion.EstadoPQRS;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

public record ItemPQRSDTO(
        @Positive
        int codigo,
        @NotEmpty
        EstadoPQRS estado,
        @NotNull
        @Length(max = 200)
        String motivo,
        @NotNull
        LocalDateTime fecha
) {
}
