package co.edu.uniquindio.proyecto.dto.paciente;

import co.edu.uniquindio.proyecto.modelo.enumeracion.Ciudad;
import co.edu.uniquindio.proyecto.modelo.enumeracion.EPS;
import co.edu.uniquindio.proyecto.modelo.enumeracion.TipoSangre;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

        public record DetallePacienteDTO(
        @Positive
        int codigo,
        @NotNull
        String correo,
        //String password,
        @NotNull
        String nombre,
        @NotNull
        String cedula,
        @NotNull
        String telefono,
        @NotEmpty
        String urlfoto,
        @NotEmpty
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
