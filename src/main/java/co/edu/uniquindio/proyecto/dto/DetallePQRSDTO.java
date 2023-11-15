package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.modelo.entidades.Mensaje;
import co.edu.uniquindio.proyecto.modelo.enumeracion.Especialidad;
import co.edu.uniquindio.proyecto.modelo.enumeracion.EstadoPQRS;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.List;


public record DetallePQRSDTO(
        @NotNull
        int codigo,
        @NotEmpty
        EstadoPQRS estado,
        @NotNull
        @Length(max = 200)
        String motivoPQRS,
        @NotNull
        @Length(max = 200)
        String nombrePaciente,
        @NotNull
        @Length(max = 200)
        String nombreMedico,
        @NotEmpty
        Especialidad especialidad,
        @NotNull
        LocalDateTime fecha,
        @NotNull
        List<RespuestaDTO> mensaje
) {
}
