package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.dto.LoginDTO;
import co.edu.uniquindio.proyecto.dto.TokenDTO;
import co.edu.uniquindio.proyecto.modelo.servicios.interfaces.AutenticacionServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@Transactional
public class AutenticacionTest {

    @Autowired
    private AutenticacionServicio autenticacionServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void loginTest(){
        try {
            TokenDTO token = autenticacionServicio.login(new LoginDTO(
                    "andres@gmail.com",
                    "1234"
            ));

            Assertions.assertNotNull(token);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
