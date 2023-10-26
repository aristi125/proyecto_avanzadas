package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.modelo.entidades.Mensaje;

import java.time.LocalDateTime;
@requestbody
public record RespuestaDTO(
        int codigoMensaje,
        String mensaje,
        String nombreUsuario,
        LocalDateTime fecha
) {
}
