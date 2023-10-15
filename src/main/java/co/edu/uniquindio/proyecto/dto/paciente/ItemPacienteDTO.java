package co.edu.uniquindio.proyecto.dto.paciente;

import co.edu.uniquindio.proyecto.modelo.enumeracion.Ciudad;
import co.edu.uniquindio.proyecto.modelo.enumeracion.EPS;
import co.edu.uniquindio.proyecto.modelo.enumeracion.EstadoCita;

import java.time.LocalDateTime;

public record ItemPacienteDTO(
        int codigo,
        String nombre,
        String cedula,
        Ciudad ciudad
) {
}
