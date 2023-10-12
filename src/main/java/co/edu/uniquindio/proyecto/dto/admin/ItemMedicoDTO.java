package co.edu.uniquindio.proyecto.dto.admin;

import co.edu.uniquindio.proyecto.modelo.enumeracion.Especialidad;

public record ItemMedicoDTO(
        int codigo,
        String telefono,
        String nombre,
        String urlFoto,
        Especialidad especialidad
) {
}
