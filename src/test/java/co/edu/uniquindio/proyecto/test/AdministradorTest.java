package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.dto.DetallePQRSDTO;
import co.edu.uniquindio.proyecto.dto.ItemPQRSDTO;
import co.edu.uniquindio.proyecto.dto.RegistroRespuestaDTO;
import co.edu.uniquindio.proyecto.dto.admin.*;
import co.edu.uniquindio.proyecto.modelo.entidades.*;
import co.edu.uniquindio.proyecto.modelo.enumeracion.Ciudad;
import co.edu.uniquindio.proyecto.modelo.enumeracion.Especialidad;
import co.edu.uniquindio.proyecto.modelo.enumeracion.EstadoPQRS;
import co.edu.uniquindio.proyecto.modelo.servicios.impl.AdministradorServicioImpl;
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
    private AdministradorServicioImpl administradorServicio;
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
    @Sql("classpath:dataset.sql")
    public void actualizarMedicoTest(){
        DetalleMedicoDTO medicoDTO = new DetalleMedicoDTO(6,"Camilo", "1234567890", Ciudad.ARMENIA, Especialidad.NEUTROLOGIA,
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

        Assertions.assertEquals(6, codigoBuscado);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarMedico(){
        try {
            administradorServicio.eliminarMedico(6);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarMedico(){
        try{
            List<ItemMedicoDTO> medicos = administradorServicio.listarMedico();
            Assertions.assertNotNull(medicos);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerMedico(){
        try {
            DetalleMedicoDTO admin = administradorServicio.obtenerMedico(6);

            Assertions.assertEquals("Andres", admin.nombre());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarPQRS(){
        try{
            List<ItemPQRSDTO> pqrs = administradorServicio.listarPQRS();
            Assertions.assertNotNull(pqrs);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void verDetallePQRS(){
        try {
            DetallePQRSDTO pqrsdto = administradorServicio.verDetallePQRS(1);
            Assertions.assertEquals(EstadoPQRS.APROBADO, pqrsdto.estado());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void responderPQRS(){
        try{
            administradorServicio.responderPQRS(new RegistroRespuestaDTO(1, 1, 2, "pqrs resuelta"));
            DetallePQRSDTO pqrs =  administradorServicio.verDetallePQRS(1);
            Assertions.assertEquals("pqrs resuelta", pqrs.mensaje().get(0).mensaje());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void cambiarEstadoPQRS(){
        try{
            administradorServicio.cambiarEstadoPQRS(1, EstadoPQRS.FINALIZADO);
            DetallePQRSDTO pqrs =  administradorServicio.verDetallePQRS(1);
            Assertions.assertEquals(EstadoPQRS.FINALIZADO, pqrs.estado());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarCitas(){
        try{
            List<ItemCitaDTOAdmin> citas = administradorServicio.listarCitas();
            Assertions.assertNotNull(citas);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
