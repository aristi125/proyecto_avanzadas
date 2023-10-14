package co.edu.uniquindio.proyecto.dto.medico;

import co.edu.uniquindio.proyecto.modelo.enumeracion.Ciudad;
import co.edu.uniquindio.proyecto.modelo.enumeracion.Especialidad;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;

import java.util.List;

public record HistorialPacienteDTO(
        @Positive
        int codigo,
        @NotEmpty @Length(max = 200)
        String nombre,
        @NotEmpty @Length(max = 10)
        String cedula,
        String tratamiento,
        String diagnostico,
        String notasMedicas,
        @NotEmpty
        String motivo
) {
}
