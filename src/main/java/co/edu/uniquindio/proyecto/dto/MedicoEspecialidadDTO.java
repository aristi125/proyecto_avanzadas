package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.modelo.enumeracion.Especialidad;

public record MedicoEspecialidadDTO(
        int codigoPaciente,
        Especialidad especialidad
) {
}
