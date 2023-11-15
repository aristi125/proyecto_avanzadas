package co.edu.uniquindio.proyecto.dto.medico;

import co.edu.uniquindio.proyecto.modelo.entidades.Cita;
import co.edu.uniquindio.proyecto.modelo.enumeracion.EPS;
import co.edu.uniquindio.proyecto.modelo.enumeracion.EstadoCita;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

public record ItemCitasActualDTOMedico(
        @Positive
        int codigoCita,
        @NotNull
        @Length(max = 10)
        String cedulaPaciente,
        @NotNull
        @Length(max = 200)
        String nombrePaciente,

        String urlFoto,
        EstadoCita estadoCita,
        EPS eps


) {
}
