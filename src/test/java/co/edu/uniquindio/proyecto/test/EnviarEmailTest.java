package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.dto.EmailDTO;
import co.edu.uniquindio.proyecto.modelo.servicios.interfaces.EmailServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
public class EnviarEmailTest {
    @Autowired
    private EmailServicio emailServicio;

    @Test
    public void enviarEmailTest(){
        try {
            emailServicio.enviarEmail(new EmailDTO(
                    "Funciona",
                    "Avanzadas Programacion",
                    "michael125lol@gmail.com"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
