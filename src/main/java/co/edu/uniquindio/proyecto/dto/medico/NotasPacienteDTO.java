package co.edu.uniquindio.proyecto.dto.medico;

import co.edu.uniquindio.proyecto.modelo.entidades.Atencion;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;

public record NotasPacienteDTO(
        @Positive
        int codigo,
        @NotNull
        @Length(max = 200)
        String diagnostico,
        @NotNull
        @Length(max = 200)
        String tratamiento,
        @NotNull
        @Length(max = 200)
        String notasMedicas
) {
}
