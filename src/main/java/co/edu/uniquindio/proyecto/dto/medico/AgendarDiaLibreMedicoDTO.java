package co.edu.uniquindio.proyecto.dto.medico;

import java.time.LocalDateTime;

public record AgendarDiaLibreMedicoDTO(
        int codigo,
        LocalDateTime fechaDiaLibre
) {
}
