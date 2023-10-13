package co.edu.uniquindio.proyecto.dto.medico;

import co.edu.uniquindio.proyecto.modelo.entidades.Cita;
import co.edu.uniquindio.proyecto.modelo.enumeracion.EPS;
import co.edu.uniquindio.proyecto.modelo.enumeracion.EstadoCita;

import java.time.LocalDateTime;

public record ItemCitasActualDTOMedico(
        int codigoCita,
        String cedulaPaciente,
        String nombrePaciente,
        String urlFoto,
        EstadoCita estadoCita,
        EPS eps


) {
}
