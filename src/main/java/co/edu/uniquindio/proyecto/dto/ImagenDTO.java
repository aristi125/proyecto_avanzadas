package co.edu.uniquindio.proyecto.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ImagenDTO (
        @Positive
        String id,
        @NotNull
        String url
){
}
