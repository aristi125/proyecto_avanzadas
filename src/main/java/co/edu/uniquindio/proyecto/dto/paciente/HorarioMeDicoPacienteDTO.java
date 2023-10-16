package co.edu.uniquindio.proyecto.dto.paciente;

import java.time.LocalTime;

public record HorarioMeDicoPacienteDTO(
        String dia,
        LocalTime horaIncio,
        LocalTime horaSalida
) {
}
