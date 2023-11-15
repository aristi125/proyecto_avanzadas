package co.edu.uniquindio.proyecto.dto.paciente;

import co.edu.uniquindio.proyecto.dto.admin.HorarioDTO;
import co.edu.uniquindio.proyecto.modelo.enumeracion.Especialidad;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.List;

public record AgendarCitaPacienteDTO(
        @NotNull
        int codigoPaciente,
        @NotNull
        int codigoMedico,
        @NotNull
        @Length(max = 200)
        String motivo,
        @NotEmpty
        LocalDateTime fechaCita

) {
}
