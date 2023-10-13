package co.edu.uniquindio.proyecto.dto.medico;

import co.edu.uniquindio.proyecto.modelo.entidades.Atencion;

public record NotasPacienteDTO(
        int codigo,
        String diagnostico,
        String tratamiento,
        String notasMedicas
) {
}
