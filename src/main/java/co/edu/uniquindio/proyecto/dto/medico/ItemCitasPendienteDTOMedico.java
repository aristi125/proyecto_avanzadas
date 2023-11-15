package co.edu.uniquindio.proyecto.dto.medico;

import co.edu.uniquindio.proyecto.modelo.enumeracion.EPS;
import co.edu.uniquindio.proyecto.modelo.enumeracion.EstadoCita;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDateTime;

public record ItemCitasPendienteDTOMedico(
        int codigoCita,
        String cedulaPaciente,
        String nombrePaciente,
        @NotEmpty
        String urlFoto,
        @NotEmpty
        LocalDateTime fechaCitasFutura,
        @NotEmpty
        EPS eps,
        @NotEmpty
        EstadoCita estadoCita
) {
}
