package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.modelo.enumeracion.Especialidad;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record MedicoEspecialidadDTO(
        @Positive
        int codigoPaciente,
        @NotEmpty
        Especialidad especialidad
) {
}
