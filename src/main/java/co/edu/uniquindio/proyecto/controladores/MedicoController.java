package co.edu.uniquindio.proyecto.controladores;

import co.edu.uniquindio.proyecto.dto.MensajeDTO;
import co.edu.uniquindio.proyecto.dto.medico.*;
import co.edu.uniquindio.proyecto.modelo.servicios.interfaces.MedicoServicio;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicos")
@RequiredArgsConstructor
public class MedicoController {

    private final MedicoServicio medicoServicio;

    @GetMapping("/listar-citas-pendientes/{codigo}")
    public ResponseEntity<MensajeDTO<List<ItemCitasPendienteDTOMedico>>> listarCitasPendientes(@PathVariable int codigo) throws Exception{
        return ResponseEntity.ok().body(new MensajeDTO<>(false, medicoServicio.listarCitasPendientes(codigo)));
    }

    @PostMapping("/atender-citas")
    public ResponseEntity<MensajeDTO<String>> atenderCitas(@Valid @RequestBody AtenderConsultaPacienteDTO atenderConsultaPacienteDTO) throws Exception {
        medicoServicio.atenderCitas(atenderConsultaPacienteDTO);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, "Se atendio la consulta"));
    }

    @GetMapping("/listar-una-cita-pacientes/{codigo}")
    public ResponseEntity<MensajeDTO<List<HistorialPacienteDTO>>> listasUnaCitasPaciente( @PathVariable int codigo) throws Exception {
        return ResponseEntity.ok().body(new MensajeDTO<>(false, medicoServicio.listasUnaCitasPaciente(codigo)));
    }

    @PostMapping("/agendar-dia-libre")
    public ResponseEntity<MensajeDTO<String>> agendarDiaLibre(@Valid @RequestBody DiaLibreDTO diaLibreDTO) throws Exception {
        medicoServicio.agendarDiaLibre(diaLibreDTO);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, "Se agendo correctamente la cita"));
    }
    @GetMapping("/listar-todas-citas-pacientes/{codigo}")
    public ResponseEntity<MensajeDTO<List<ItemCitasActualDTOMedico>>> listarTodasCitasPacientes(@PathVariable int codigo) throws Exception {
        return ResponseEntity.ok().body(new MensajeDTO<>(false, medicoServicio.listarTodasCitasPacientes(codigo)));
    }
}
