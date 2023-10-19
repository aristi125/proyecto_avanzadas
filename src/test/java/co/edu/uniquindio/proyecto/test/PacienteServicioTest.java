package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.dto.DetallePQRSDTO;
import co.edu.uniquindio.proyecto.dto.ItemPQRSDTO;
import co.edu.uniquindio.proyecto.dto.RegistroRespuestaDTO;
import co.edu.uniquindio.proyecto.dto.admin.ItemCitaDTOAdmin;
import co.edu.uniquindio.proyecto.dto.paciente.DetatellePacienteDTO;
import co.edu.uniquindio.proyecto.dto.paciente.ItemCitaPendientePacienteDTO;
import co.edu.uniquindio.proyecto.dto.paciente.ItemPacienteDTO;
import co.edu.uniquindio.proyecto.dto.paciente.RegistroPacienteDTO;
import co.edu.uniquindio.proyecto.modelo.entidades.Cita;
import co.edu.uniquindio.proyecto.modelo.entidades.Medico;
import co.edu.uniquindio.proyecto.modelo.enumeracion.*;
import co.edu.uniquindio.proyecto.modelo.servicios.interfaces.PacienteServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
@Transactional
public class PacienteServicioTest {
    @Autowired
    private PacienteServicio pacienteServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void registrarseTest(){
        RegistroPacienteDTO pacienteDTOS = new RegistroPacienteDTO(
                "michael@gmail.com",
                "123",
                "michael",
                "1234567890",
                "3116674102",
                "foto",
                LocalDate.of(2023, 10, 15),
                "picadura de avispa",
                Ciudad.ARMENIA,
                EPS.NUEVA_EPS,
                TipoSangre.A_NEGATIVO
        );
        try {
            //Guardamos el registro usando el metodo del servicio
            int nuevo = pacienteServicio.registrarse(pacienteDTOS);
            //Comprobamos que si haya quedado guardado, Si se guardo debe retornar el codigo (No 0)
            Assertions.assertNotEquals(1, nuevo);
        }catch (Exception e){
            throw new RuntimeException();
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void editarPerfilTest() throws Exception {
        DetatellePacienteDTO guardado = pacienteServicio.verDetallePaciente(1);
        DetatellePacienteDTO modificado = new DetatellePacienteDTO(
                guardado.codigo(),
                guardado.correo(),
                guardado.nombre(),
                guardado.cedula(),
                "3217122375",
                guardado.urlfoto(),
                guardado.fechaNacimiento(),
                guardado.alergias(),
                guardado.ciudad(),
                guardado.eps(),
                guardado.tipoSangre()
        );
        //se invoca el servicio de actualizar los datos
        pacienteServicio.editarPerfil(modificado);
        //Se obtiene nuevamente el paciente para comprobar que si se haya actualizado
        DetatellePacienteDTO objetoModificado = pacienteServicio.verDetallePaciente(1);
        //se comprueba que el teledonodel paciente sea el que se le asigno en la actualizacion
        Assertions.assertEquals("3217122375", objetoModificado.telefono());
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarCuentaTest() throws Exception {
        //se borra el paciente con el codigo 1
        pacienteServicio.eliminarCuenta(1);
        //si intentamos buscar un paciente con el codigo del paciente
        // borrado debemos obtener una excepcion indicando que ya no existe
        Assertions.assertThrows(Exception.class, ()-> pacienteServicio.verDetallePaciente(1));
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void enviarLinkRecuperacion(){

    }
    @Test
    @Sql("classpath:dataset.sql")
    public void cambiarPassword(){

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void agendarCita(){

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void crearPQRS(){

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarPQRSPaciente(){
        try{
            List<ItemPQRSDTO> pqrs = pacienteServicio.listarPQRSPaciente();
            Assertions.assertNotNull(pqrs);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void verDetallePQRS(){
        try {
            DetallePQRSDTO pqrsdto = pacienteServicio.verDetallePQRS(1);
            Assertions.assertEquals(EstadoPQRS.APROBADO, pqrsdto.estado());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void responderPQRS(){
        try{
            pacienteServicio.responderPQRS(new RegistroRespuestaDTO(1, 1, 2, "pqrs resuelta"));
            DetallePQRSDTO pqrs =  pacienteServicio.verDetallePQRS(1);
            Assertions.assertEquals("pqrs resuelta", pqrs.mensaje().get(0).mensaje());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarCitasPaciente(){
        try{
            List<ItemCitaPendientePacienteDTO> citas = pacienteServicio.listarCitasPaciente(1);
            Assertions.assertNotNull(citas);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void filtrarCitasPorFecha(){
        try {
            Medico medico = new Medico();
            Cita cita = new Cita();
            List<ItemCitaPendientePacienteDTO> pendientes = null;
            pendientes =  pacienteServicio.filtrarCitasPorFecha(new ItemCitaPendientePacienteDTO(
                    cita.getCodigo(),
                    medico.getCedula(),
                    medico.getNombre(),
                    cita.getFechaCita(),
                    Especialidad.CARDIOLGIA,
                    EstadoCita.PROGRAMADA));
            Assertions.assertNotNull(pendientes);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void filtrarCitasPorMedico(){

        try {
            Medico medico = new Medico();
            Cita cita = new Cita();
            List<ItemCitaPendientePacienteDTO> pendientes = null;
            pendientes =  pacienteServicio.filtrarCitasPorMedico(new ItemCitaPendientePacienteDTO(
                    cita.getCodigo(),
                    medico.getCedula(),
                    medico.getNombre(),
                    cita.getFechaCita(),
                    Especialidad.CARDIOLGIA,
                    EstadoCita.PROGRAMADA));
            Assertions.assertNotNull(pendientes);
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }
    @Test
    @Sql("classpath:dataset.sql")
    public void verHistorialCita() throws Exception {
        //obtenemos la lista de todos los paciente
        List<ItemPacienteDTO> historialPaciete = pacienteServicio.verHistorialCita();
        //si en el dataset creamos 5 pacientes, entonces el tamaño de la lista debe ser 5
        Assertions.assertEquals(0, historialPaciete.size());
    }
}
