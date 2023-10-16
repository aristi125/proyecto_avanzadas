package co.edu.uniquindio.proyecto.dto.paciente;

public record CambiarPasswordDTO(
        int codigo,
        String password,
        String correo
) {
}
