package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.dto.medico.HistorialPacienteDTO;
import co.edu.uniquindio.proyecto.dto.medico.ItemCitasPendienteDTOMedico;
import co.edu.uniquindio.proyecto.dto.paciente.ItemCitaPendientePacienteDTO;
import co.edu.uniquindio.proyecto.modelo.servicios.interfaces.MedicoServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@SpringBootTest
@Transactional
public class MedicoServicioTest {
    @Autowired
    private MedicoServicio medicoServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void ListarCitasPendientesTest(){
        try{
            List<ItemCitasPendienteDTOMedico> citas = medicoServicio.listarCitasPendientes(1);
            Assertions.assertNotNull(citas);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void atenderCitasTest(){

    }
    @Test
    @Sql("classpath:dataset.sql")
    public void listasUnaCitasPacienteTest(){
        try{
            List<HistorialPacienteDTO> citas = medicoServicio.listasUnaCitasPaciente(1);
            Assertions.assertNotNull(citas);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void agendarDiaLibre(){

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarTodasCitasPacientes(){
        try{
            List<HistorialPacienteDTO> citas = medicoServicio.listarTodasCitasPacientes(1);
            Assertions.assertNotNull(citas);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
