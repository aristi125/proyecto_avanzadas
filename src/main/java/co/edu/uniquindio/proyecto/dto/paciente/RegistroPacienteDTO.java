package co.edu.uniquindio.proyecto.dto.paciente;

import co.edu.uniquindio.proyecto.modelo.enumeracion.Ciudad;
import co.edu.uniquindio.proyecto.modelo.enumeracion.EPS;
import co.edu.uniquindio.proyecto.modelo.enumeracion.Estado;
import co.edu.uniquindio.proyecto.modelo.enumeracion.TipoSangre;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

public record RegistroPacienteDTO(
        @NotBlank
        @Length(max = 80, message = "El correo debe tener maximo 80 caracteres")
        @Email(message = "Ingrese un correo valido")
        String correo,
        @NotBlank
        String password,
        @NotBlank
        @Length(max = 200, message = "El nombre puede tener maximo 200 caracteres")
        String nombre,
        @NotBlank @Length(max = 10, message = "La cedula debe tener maximo 10 caracteres")
        String cedula,
        @NotBlank
        @Length(max = 20, message = "El telefono debe tener maximos 20 caracteres")
        String telefono,
        @NotBlank
        String urlfoto,
        @NotNull
        @Past(message = "Seleccione una fecha de nacimiento correcta")
        LocalDate fechaNacimiento,
        @NotNull
        String alergias,
        @NotNull
        Ciudad ciudad,
        @NotNull
        EPS eps,
        @NotNull
        TipoSangre tipoSangre
) {
}
