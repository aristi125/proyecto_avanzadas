package co.edu.uniquindio.proyecto.dto.paciente;

import co.edu.uniquindio.proyecto.modelo.enumeracion.Ciudad;
import co.edu.uniquindio.proyecto.modelo.enumeracion.EPS;
import co.edu.uniquindio.proyecto.modelo.enumeracion.TipoSangre;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public record DetallePacienteDTO(
        @Positive
        int codigo,
        String correo,
        //String password,
        String nombre,
        String cedula,
        String telefono,
        String urlfoto,
        LocalDate fechaNacimiento,
        String alergias,
        Ciudad ciudad,
        EPS eps,
        TipoSangre tipoSangre
) {
}
