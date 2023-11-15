package co.edu.uniquindio.proyecto.dto.paciente;

import java.time.LocalDate;

public record FiltroBusquedaDTO(
        int codigoPaciente,
        LocalDate fecha,
        String nombreMedico

) {
}
