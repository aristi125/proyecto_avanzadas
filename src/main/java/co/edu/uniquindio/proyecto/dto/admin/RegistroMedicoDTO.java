package co.edu.uniquindio.proyecto.dto.admin;

import co.edu.uniquindio.proyecto.modelo.enumeracion.Ciudad;
import co.edu.uniquindio.proyecto.modelo.enumeracion.Especialidad;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

import java.util.List;

public record RegistroMedicoDTO(
        //PREFUNTAR SI SE PUEDE HACER ESO
        @NotBlank
        @Length(max = 200)
        String nombre,

        @NotBlank @Length(max = 10)
        String cedula,

        @NotNull
        Ciudad ciudad,

        @NotNull
        Especialidad especialidad,

        @NotBlank @Length(max = 20)
        String telefono,
        @NotNull @Length(max = 100) @Email
        String correo,
        @NotNull @Length(max = 200)
        String password,
        @NotNull
        String urlFoto,
        @NotEmpty
        List<HorarioDTO> horarios
) {
}
