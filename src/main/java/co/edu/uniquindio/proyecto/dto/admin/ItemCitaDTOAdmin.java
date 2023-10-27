package co.edu.uniquindio.proyecto.dto.admin;

import co.edu.uniquindio.proyecto.modelo.enumeracion.Especialidad;
import co.edu.uniquindio.proyecto.modelo.enumeracion.EstadoCita;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

public record ItemCitaDTOAdmin(
        @Positive
        int codigoCita,
        @NotEmpty @Length(max = 10)
        String cedulaPaciente,
        @NotEmpty @Length(max = 200)
        String nombrePaciente,
        @NotEmpty @Length(max = 200)
        String nombreMedico,
        @NotEmpty
        Especialidad especialidad,
        EstadoCita estadoCita,
        @NotNull
        LocalDateTime fecha
) {
}
