package co.edu.uniquindio.proyecto.dto.paciente;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;

public record RecupararPasswordPacienteDTO(
        @Positive
        int codigo,
        @NotNull
        @Length(max = 200)
        String nombre,
        @NotNull
        @Length(max = 100)
        String correo,
        @NotNull
        @Length(max = 200)
        String password
) {
}
