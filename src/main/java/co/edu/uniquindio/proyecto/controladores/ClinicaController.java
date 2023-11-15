package co.edu.uniquindio.proyecto.controladores;

import co.edu.uniquindio.proyecto.dto.MensajeDTO;
import co.edu.uniquindio.proyecto.modelo.enumeracion.Ciudad;
import co.edu.uniquindio.proyecto.modelo.enumeracion.EPS;
import co.edu.uniquindio.proyecto.modelo.enumeracion.Especialidad;
import co.edu.uniquindio.proyecto.modelo.enumeracion.TipoSangre;
import co.edu.uniquindio.proyecto.modelo.servicios.interfaces.ClinicaServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/clinica")
@RequiredArgsConstructor
public class ClinicaController {
    private final ClinicaServicio clinicaServicio;

    //SE AGREGARON LOS DEMAS CAMPOS DE LA CLINICA QUE SAQUE 0
    @GetMapping("/listar-ciudades")
    public ResponseEntity<MensajeDTO<List<Ciudad>>> listarCiudades(){
        return ResponseEntity.ok().body(new MensajeDTO<>(false, clinicaServicio.listarCiudades()));
    }

    @GetMapping("/listar-especialidades")
    public ResponseEntity<MensajeDTO<List<Especialidad>>> listarEspecialidadesMedico(){
        return ResponseEntity.ok().body(new MensajeDTO<>(false, clinicaServicio.listarEspecialidadesMedico()));
    }

    @GetMapping("/listar-eps")
    public ResponseEntity<MensajeDTO<List<EPS>>> listarEPS(){
        return ResponseEntity.ok().body(new MensajeDTO<>(false, clinicaServicio.listarEPS()));
    }

    @GetMapping("/listar-tipo-sangre")
    public ResponseEntity<MensajeDTO<List<TipoSangre>>> listarTipoSangre(){
        return ResponseEntity.ok().body(new MensajeDTO<>(false, clinicaServicio.listarTipoSangre()));
    }
}
