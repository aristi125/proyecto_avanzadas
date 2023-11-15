package co.edu.uniquindio.proyecto.dto.medico;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;
import java.time.LocalTime;

public record DiaLibreDTO(
        @Positive
        int codigo,
        @NotNull
        LocalDate diaLibre
) {
}
