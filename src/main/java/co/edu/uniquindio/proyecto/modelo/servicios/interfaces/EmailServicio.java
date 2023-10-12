package co.edu.uniquindio.proyecto.modelo.servicios.interfaces;

import co.edu.uniquindio.proyecto.dto.EmailDTO;

public interface EmailServicio {
    String emailcorreo(EmailDTO emailDTO) throws Exception;
}
