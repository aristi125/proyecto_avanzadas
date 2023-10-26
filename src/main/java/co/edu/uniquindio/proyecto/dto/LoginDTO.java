package co.edu.uniquindio.proyecto.dto;
@requestbody
public record LoginDTO(
        String correo,
        String password
) {
}
