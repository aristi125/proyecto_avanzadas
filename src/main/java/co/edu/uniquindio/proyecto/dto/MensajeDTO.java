package co.edu.uniquindio.proyecto.dto;
@requestbodymem
public record MensajeDTO<T>(
        boolean error,
        T respuesta
) {
}
