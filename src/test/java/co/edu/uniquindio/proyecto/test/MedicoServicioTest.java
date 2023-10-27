package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.dto.medico.AtenderConsultaPacienteDTO;
import co.edu.uniquindio.proyecto.dto.medico.DiaLibreDTO;
import co.edu.uniquindio.proyecto.dto.medico.HistorialPacienteDTO;
import co.edu.uniquindio.proyecto.dto.medico.ItemCitasPendienteDTOMedico;
import co.edu.uniquindio.proyecto.dto.paciente.ItemCitaPendientePacienteDTO;
import co.edu.uniquindio.proyecto.modelo.entidades.DiaLibre;
import co.edu.uniquindio.proyecto.modelo.entidades.Paciente;
import co.edu.uniquindio.proyecto.modelo.servicios.interfaces.MedicoServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.util.ArrayList;
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
            List<ItemCitasPendienteDTOMedico> citas = medicoServicio.listarCitasPendientes(6);
            Assertions.assertNotNull(citas);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void atenderCitasTest(){
        try{
            AtenderConsultaPacienteDTO atender = new AtenderConsultaPacienteDTO(
                    1,
                    "Tiene aaaaaaa ",
                    "Notas médicas",
                    "tratamiento es:......."

            );
            int atenderDTO = medicoServicio.atenderCitas(atender);
            Assertions.assertNotEquals(0, atenderDTO);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void listasUnaCitasPacienteTest(){
        try{
            List<HistorialPacienteDTO> citas = medicoServicio.listasUnaCitasPaciente(2);
            Assertions.assertNotNull(citas);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void agendarDiaLibre(){
        LocalDate fechaLibre = LocalDate.of(2023, 12, 24);
        DiaLibreDTO diaLibreDTO = new DiaLibreDTO(
                6,
                fechaLibre
        );

        try {
            int codigo = medicoServicio.agendarDiaLibre(diaLibreDTO);
            Assertions.assertNotEquals(0,codigo);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarTodasCitasPacientes(){
        try{
            List<HistorialPacienteDTO> citas = medicoServicio.listarTodasCitasPacientes(2);
            Assertions.assertNotNull(citas);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
