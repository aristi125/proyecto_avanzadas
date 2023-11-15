package co.edu.uniquindio.proyecto.dto.medico;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;

import java.util.List;

public record AtenderConsultaPacienteDTO(
        @Positive
        int codigoCita,
        @NotNull
        @Length(max = 200)
        String diagnostico,
        @NotNull
        @Length(max = 200)
        String notas,
        @NotNull
        @Length(max = 200)
        String tratamiento

) {
}
