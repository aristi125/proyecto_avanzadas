package co.edu.uniquindio.proyecto.controladores;

import co.edu.uniquindio.proyecto.dto.*;
import co.edu.uniquindio.proyecto.dto.paciente.*;
import co.edu.uniquindio.proyecto.modelo.servicios.interfaces.PacienteServicio;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
@RequiredArgsConstructor
public class PacienteController {

    private final PacienteServicio pacienteServicio;

    @PostMapping("/registrar")
    public ResponseEntity<MensajeDTO<String>> registrarse(@Valid @RequestBody RegistroPacienteDTO registroPacienteDTO) throws Exception{
        pacienteServicio.registrarse(registroPacienteDTO);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, "Se registro correctamente el paciente"));
    }

    @PutMapping("/editar-perfil")
    public ResponseEntity<MensajeDTO<String>> editarPerfil(@Valid @RequestBody DetallePacienteDTO pacienteDTO) throws Exception{
        pacienteServicio.editarPerfil(pacienteDTO);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, "Paciente actualizado correctamente"));
    }
    @DeleteMapping("/eliminar/{codigo}")
    public ResponseEntity<MensajeDTO<String>> eliminarCuenta(@PathVariable int codigo) throws Exception{
        pacienteServicio.eliminarCuenta(codigo);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "pacietne eliminado correctamente"));
    }
    //TOCA HACERLO
    @PutMapping("/enviar-link-recuperacion")
    public ResponseEntity<MensajeDTO <String>> enviarLinkRecuperacion(@Valid @RequestBody RecupararPasswordPacienteDTO passwordPacienteDTO) throws Exception{
        pacienteServicio.enviarLinkRecuperacion(passwordPacienteDTO);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, "Se envio correctamente el link de recuperacion"));
    }
    @PutMapping("/cambiar-password")
    public ResponseEntity<MensajeDTO <String>> cambiarPassword(@Valid @RequestBody CambiarPasswordDTO cambiarPasswordDTO) throws Exception{
        pacienteServicio.cambiarPassword(cambiarPasswordDTO);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, "El paciente cambio su contraseña correctatmen"));
    }

    @PostMapping("/agendar-cita")
    public ResponseEntity<MensajeDTO <String>> agendarCita(@Valid @RequestBody AgendarCitaPacienteDTO agendarCitaPacienteDTO) throws Exception{
        pacienteServicio.agendarCita(agendarCitaPacienteDTO);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, "Se agendo correctamente la cita"));
    }
    //Corregir para que los parametros esten en un DTO
    @PostMapping("/crear-pqrs")
    public ResponseEntity<MensajeDTO <String>> crearPQRS(@Valid @RequestBody CrearPQRSDTO crearPqrsdto) throws Exception{
        pacienteServicio.crearPQRS(crearPqrsdto);
        return ResponseEntity.ok().body(new MensajeDTO<>(false,"Se creo correctamente la PQRS"));
    }

    @GetMapping("/listar-pqrs-paciente")
    public ResponseEntity<MensajeDTO <List<ItemPQRSDTO>>> listarPQRSPaciente(int codigo) throws Exception{
        return ResponseEntity.ok().body(new MensajeDTO<>(false,pacienteServicio.listarPQRSPaciente(codigo)));
    }

    @GetMapping("/ver-detalle-pqrs/{codigo}")
    public ResponseEntity<MensajeDTO <DetallePQRSDTO>> verDetallePQRS(@PathVariable int codigo) throws Exception{
        return ResponseEntity.ok().body(new MensajeDTO<>(false, pacienteServicio.verDetallePQRS(codigo)));
    }
    @PostMapping("/responder-pqrs")
    public ResponseEntity<MensajeDTO <String>> responderPQRS(@Valid @RequestBody RegistroRespuestaDTO registroRespuestaDTO) throws Exception{
        pacienteServicio.responderPQRS(registroRespuestaDTO);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, "Se respondonio correctamente"));
    }

    @GetMapping("/listar-citas-paciente/{codigo}")
    public ResponseEntity<MensajeDTO <List<ItemCitaPendientePacienteDTO>>> listarCitasPaciente(@PathVariable int codigo) throws Exception{
        return ResponseEntity.ok().body(new MensajeDTO<>(false, pacienteServicio.listarCitasPaciente(codigo)));
    }

    @GetMapping("/filtrar-citas-por-fecha")
    public ResponseEntity<MensajeDTO <List<ItemCitaPendientePacienteDTO>>> filtrarCitasPorFecha(@Valid @RequestBody FiltroBusquedaDTO filtroBusquedaDTO) throws Exception{
        return ResponseEntity.ok().body(new MensajeDTO<>(false, pacienteServicio.filtrarCitasPorFecha(filtroBusquedaDTO)));
    }

    //Corregir para que use un DTO
    @GetMapping("/filtrar-citas-por-medico")
    public ResponseEntity<MensajeDTO <List<ItemCitaPendientePacienteDTO>>> filtrarCitasPorMedico(@Valid @RequestBody FiltroBusquedaDTO filtroBusquedaDTO) throws Exception{
        return ResponseEntity.ok().body(new MensajeDTO<>(false, pacienteServicio.filtrarCitasPorMedico(filtroBusquedaDTO)));
    }

    @GetMapping("/listar-medicos-especialidad")
    public ResponseEntity<MensajeDTO <List<ItemCitaPendientePacienteDTO>>> filtrarCitasPorMedico(@Valid @RequestBody MedicoEspecialidadDTO especialidadDTO) throws Exception{
        return ResponseEntity.ok().body(new MensajeDTO<>(false, pacienteServicio.listarMedicosEspecialidad(especialidadDTO)));
    }

    @GetMapping("/detalle/{codigo}")
    public ResponseEntity<MensajeDTO<DetallePacienteDTO>> verDetallePaciente(@PathVariable int codigo) throws Exception{
        return ResponseEntity.ok().body(new MensajeDTO<>(false, pacienteServicio.verDetallePaciente(codigo))) ;
    }

}
