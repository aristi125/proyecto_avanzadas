package co.edu.uniquindio.proyecto.dto.admin;

import co.edu.uniquindio.proyecto.modelo.enumeracion.Ciudad;
import co.edu.uniquindio.proyecto.modelo.enumeracion.Especialidad;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;

import java.util.List;

public record DetalleMedicoDTO(
        @Positive
        int codigo,
        @NotEmpty @Length(max = 200)
        String nombre,
        @NotEmpty @Length(max = 10)
        String cedula,
        @NotNull
        Ciudad ciudad   ,
        @NotNull
        Especialidad especialidad,
        @NotEmpty @Length(max = 20)
        String telefono,
        @NotEmpty @Length(max = 100)
        String correo,
        @NotEmpty
        String urlFoto,
        //@NotEmpty
        List<HorarioDTO> horarios
) {
}
