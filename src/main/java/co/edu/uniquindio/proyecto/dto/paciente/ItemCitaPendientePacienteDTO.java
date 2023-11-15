package co.edu.uniquindio.proyecto.dto.paciente;

import co.edu.uniquindio.proyecto.modelo.enumeracion.Especialidad;
import co.edu.uniquindio.proyecto.modelo.enumeracion.EstadoCita;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

public record ItemCitaPendientePacienteDTO(
        @Positive
        int codigoCita,
        @NotNull
        @Length(max = 10)
        String cedulaMedico,
        @NotNull
        @Length(max = 200)
        String nombreMedico,
        @NotEmpty
        LocalDateTime fechaCita,
        @NotEmpty
        Especialidad especialidad,
        @NotEmpty
        EstadoCita estadoCita
) {
}
