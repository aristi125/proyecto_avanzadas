package co.edu.uniquindio.proyecto.dto.admin;

import co.edu.uniquindio.proyecto.modelo.enumeracion.Ciudad;
import co.edu.uniquindio.proyecto.modelo.enumeracion.Especialidad;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

import java.util.List;

public record RegistroMedicoDTO(
        //PREFUNTAR SI SE PUEDE HACER ESO
        @Column(nullable = false, length = 200)
        @NotBlank
        @Length(max = 200)
        String nombre,
        @NotBlank @Length(max = 10)
        String cedula,
        @NotNull @Min(0) @Max(3)
        Ciudad ciudad,
        @NotNull @Min(0) @Max(5)
        Especialidad especialidad,
        @NotBlank @Length(max = 20)
        String telefono,
        @NotNull @Length(max = 80) @Email
        String correo,
        @NotNull
        String password,
        @NotNull
        String urlFoto,
        @NotEmpty
        List<HorarioDTO> horarios
) {
}
