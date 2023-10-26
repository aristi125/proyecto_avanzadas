package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.modelo.enumeracion.EstadoPQRS;

import java.time.LocalDateTime;
@bodyrequest
public record ItemPQRSDTO(
        int codigo,
        EstadoPQRS estado,
        String motivo,
        LocalDateTime fecha,
        String nombrePaciente
) {
}
