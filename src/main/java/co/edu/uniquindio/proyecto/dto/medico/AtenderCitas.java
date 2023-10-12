package co.edu.uniquindio.proyecto.dto.medico;

import java.time.LocalDateTime;
import java.util.List;

public record AtenderCitas(
        String nombrePaciente,
        String cedula,
        LocalDateTime fechaCitaActual


) {
}
