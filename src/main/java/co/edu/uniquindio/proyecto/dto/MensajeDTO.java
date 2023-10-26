package co.edu.uniquindio.proyecto.dto;
@requestbody
public record MensajeDTO<T>(
        boolean error,
        T respuesta
) {
}
