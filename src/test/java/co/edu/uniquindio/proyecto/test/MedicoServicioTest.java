package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.modelo.servicios.interfaces.MedicoServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
public class MedicoServicioTest {
    @Autowired
    private MedicoServicio medicoServicio;

    @Test
    public void ListarCitasPendientesTest(){

    }
    @Test
    public void atenderCitasTest(){

    }
    @Test
    public void listasUnaCitasPacienteTest(){

    }
    @Test
    public void agendarDiaLibre(){

    }
    @Test
    public void listarCitasPorEstado(){

    }
    @Test
    public void listarTodasCitasPacientes(){

    }
}
