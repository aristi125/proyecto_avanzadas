package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.dto.admin.DetalleMedicoDTO;
import co.edu.uniquindio.proyecto.dto.admin.HorarioDTO;
import co.edu.uniquindio.proyecto.dto.admin.RegistroMedicoDTO;
import co.edu.uniquindio.proyecto.modelo.enumeracion.Ciudad;
import co.edu.uniquindio.proyecto.modelo.enumeracion.Especialidad;
import co.edu.uniquindio.proyecto.modelo.servicios.interfaces.AdministradorServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Transactional
public class AdministradorTest {
    @Autowired
    private AdministradorServicio administradorServicio;
    @Test
    public void crearMedicoTest(){
        List<HorarioDTO> horarios = new ArrayList<>();
        horarios.add(new HorarioDTO("LUNES", LocalTime.of(7, 0, 0), LocalTime.of(14, 0, 0)));
        RegistroMedicoDTO medicoDTO = new RegistroMedicoDTO(
                "Pepito",
                "82872",
                Ciudad.ARMENIA,
                Especialidad.CARDIOLGIA,
                "78387",
                "pepito@gmail.com",
                "123a",
                "url_foto",
                horarios
        );

        try{
            administradorServicio.crearMedico(medicoDTO);
        }catch (Exception e){
            throw new RuntimeException();
        }
    }
    @Test
    //@Sql("dataset.sql")
    public void actualizarMedico(){
        DetalleMedicoDTO medicoDTO = new DetalleMedicoDTO(1,"Camilo", "1234567890", Ciudad.ARMENIA, Especialidad.NEUTROLOGIA,
                "3116674102","camilo@gmail.com", "ssss",null );
        List<HorarioDTO> horarios = new ArrayList<>();
        RegistroMedicoDTO registroDTO = new RegistroMedicoDTO("Pepito",
                "82872",
                Ciudad.ARMENIA,
                Especialidad.CARDIOLGIA,
                "78387",
                "pepito@gmail.com",
                "123a",
                "url_foto",horarios);
        int codigoBuscado = 0;
        try {
            administradorServicio.crearMedico(registroDTO);
            codigoBuscado = administradorServicio.actualizarMedico(medicoDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if (codigoBuscado == 0){
            throw new RuntimeException("Medico no existe, no se puede actualizar");
        }

        Assertions.assertEquals(1, codigoBuscado);
    }
}
