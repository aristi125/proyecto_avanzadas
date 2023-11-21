package co.edu.uniquindio.proyecto.dto.medico;

import co.edu.uniquindio.proyecto.modelo.enumeracion.EPS;
import co.edu.uniquindio.proyecto.modelo.enumeracion.EstadoCita;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public record ItemCitasPendienteDTOMedico(
        @Positive
        int codigoCita,
        @NotNull
        String cedulaPaciente,
        @NotNull
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
