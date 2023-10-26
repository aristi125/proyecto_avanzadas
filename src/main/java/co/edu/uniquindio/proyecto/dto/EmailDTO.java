package co.edu.uniquindio.proyecto.dto;
@bodyrequest
public record EmailDTO(
        String asunto,
        String cuerpo,
        String destinatario
) {
}
