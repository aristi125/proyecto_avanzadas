package co.edu.uniquindio.proyecto.dto.medico;

import java.util.List;

public record AtenderConsultaPacienteDTO(
        int codigoCita,
        String diagnostico,
        String notas,
        String tratamiento

) {
}
