package co.edu.uniquindio.proyecto.dto;

import java.time.LocalDate;

public record FiltroBusquedaDTO(
        int codigoPaciente,
        LocalDate fecha,
        String nombreMedico

) {
}
