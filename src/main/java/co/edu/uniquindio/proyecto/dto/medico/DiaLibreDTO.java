package co.edu.uniquindio.proyecto.dto.medico;

import java.time.LocalDate;
import java.time.LocalTime;

public record DiaLibreDTO(
        int codigo,
        LocalDate diaLibre
) {
}
