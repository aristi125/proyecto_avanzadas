package co.edu.uniquindio.proyecto.dto.admin;

import co.edu.uniquindio.proyecto.modelo.enumeracion.Especialidad;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;

public record ItemMedicoDTO(
        @Positive
        int codigo,
        @NotNull @Length(max = 10)
        String telefono,
        @NotNull @Length(max = 200)
        String nombre,
        @NotEmpty
        String urlFoto,
        @NotEmpty
        Especialidad especialidad
) {
}
