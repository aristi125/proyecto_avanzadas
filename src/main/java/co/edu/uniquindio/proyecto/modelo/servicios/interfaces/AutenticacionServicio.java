package co.edu.uniquindio.proyecto.modelo.servicios.interfaces;

import co.edu.uniquindio.proyecto.dto.LoginDTO;
import co.edu.uniquindio.proyecto.dto.TokenDTO;

public interface AutenticacionServicio {
    TokenDTO login(LoginDTO loginDTO) throws Exception;
}
