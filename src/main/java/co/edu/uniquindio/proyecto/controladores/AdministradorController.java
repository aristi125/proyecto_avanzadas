package co.edu.uniquindio.proyecto.controladores;

import co.edu.uniquindio.proyecto.dto.DetallePQRSDTO;
import co.edu.uniquindio.proyecto.dto.ItemPQRSDTO;
import co.edu.uniquindio.proyecto.dto.MensajeDTO;
import co.edu.uniquindio.proyecto.dto.RegistroRespuestaDTO;
import co.edu.uniquindio.proyecto.dto.admin.DetalleMedicoDTO;
import co.edu.uniquindio.proyecto.dto.admin.ItemCitaDTOAdmin;
import co.edu.uniquindio.proyecto.dto.admin.ItemMedicoDTO;
import co.edu.uniquindio.proyecto.dto.admin.RegistroMedicoDTO;
import co.edu.uniquindio.proyecto.modelo.enumeracion.Ciudad;
import co.edu.uniquindio.proyecto.modelo.enumeracion.EPS;
import co.edu.uniquindio.proyecto.modelo.enumeracion.Especialidad;
import co.edu.uniquindio.proyecto.modelo.enumeracion.EstadoPQRS;
import co.edu.uniquindio.proyecto.modelo.servicios.interfaces.AdministradorServicio;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/administrador")
@RequiredArgsConstructor
public class AdministradorController {

    private final AdministradorServicio administradorServicio;

    @PostMapping("/crear-medico")
    public ResponseEntity<MensajeDTO <String>> crearMedico(@Valid @RequestBody RegistroMedicoDTO medicoDTO) throws Exception{
        administradorServicio.crearMedico(medicoDTO);
        return ResponseEntity.ok().body(new MensajeDTO<>(false,"Se creo correctamente el medico"));
    }

    @PutMapping("/actualizar-medico")
    public ResponseEntity<MensajeDTO <String>> actualizarMedico(@Valid @RequestBody DetalleMedicoDTO medicoDTO) throws Exception {
        administradorServicio.actualizarMedico(medicoDTO);
        return ResponseEntity.ok().body(new MensajeDTO<>(false,"Se actualizo correctamente el medico"));
    }

    @DeleteMapping("/eliminar/{codigo}")
    public ResponseEntity<MensajeDTO <String>> eliminarMedico( @PathVariable int codigo) throws Exception{
        administradorServicio.eliminarMedico(codigo);
        return ResponseEntity.ok().body(new MensajeDTO<>(false,"Se elimino correctamente el medico"));
    }

    @GetMapping("/listar-medico")
    public ResponseEntity<MensajeDTO<List<ItemMedicoDTO>>> listarMedico() throws Exception{
        return ResponseEntity.ok().body(new MensajeDTO<>(false, administradorServicio.listarMedico()));
    }

    @GetMapping("/obtener-medico/{codigo}")
    public ResponseEntity<MensajeDTO<DetalleMedicoDTO>> obtenerMedico(@PathVariable int codigo) throws Exception{
        return ResponseEntity.ok().body(new MensajeDTO<>(false, administradorServicio.obtenerMedico(codigo)));
    }

    @GetMapping("/listar-pqrs")
    public ResponseEntity<MensajeDTO<List<ItemPQRSDTO>>> listarPQRS() throws Exception{
        return ResponseEntity.ok().body(new MensajeDTO<>(false, administradorServicio.listarPQRS()));
    }

    @GetMapping("/ver-detalle-pqrs/{codigo}")
    public ResponseEntity<MensajeDTO<DetallePQRSDTO>> verDetallePQRS(@PathVariable int codigo) throws Exception{
        return ResponseEntity.ok().body(new MensajeDTO<>(false, administradorServicio.verDetallePQRS(codigo)));
    }

    @PostMapping("/responder-pqrs")
    public ResponseEntity<MensajeDTO<String>> responderPQRS(@Valid @RequestBody RegistroRespuestaDTO registroRespuestaDTO) throws Exception{
        administradorServicio.responderPQRS(registroRespuestaDTO);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "Se ha registrado la respuesta") );
    }

    @PutMapping("/cambiar-estado-pqrs/{codigoPQRS}/{estadoPQRS}")
    public ResponseEntity<MensajeDTO<String>> cambiarEstadoPQRS( @PathVariable int codigoPQRS, @PathVariable EstadoPQRS estadoPQRS) throws Exception{
        administradorServicio.cambiarEstadoPQRS(codigoPQRS, estadoPQRS);
        return ResponseEntity.ok().body(new MensajeDTO<>(false,"Se actualizo correctamente el estado de la PQRS"));
    }

    @GetMapping("/listar-citas")
    public ResponseEntity<MensajeDTO<List<ItemCitaDTOAdmin>>> listarCitas() throws Exception{
        return ResponseEntity.ok().body(new MensajeDTO<>(false, administradorServicio.listarCitas()));
    }

    //SE AGREGARON LOS DEMAS CAMPOS DE LA CLINICA QUE SAQUE 0
    @GetMapping("/listar-ciudades")
    public ResponseEntity<MensajeDTO<List<Ciudad>>> listarCiudades(){
        return ResponseEntity.ok().body(new MensajeDTO<>(false, administradorServicio.listarCiudades()));
    }

    @GetMapping("/listar-especialidades")
    public ResponseEntity<MensajeDTO<List<Especialidad>>> listarEspecialidadesMedico(){
        return ResponseEntity.ok().body(new MensajeDTO<>(false, administradorServicio.listarEspecialidadesMedico()));
    }

    @GetMapping("/listar-eps")
    public ResponseEntity<MensajeDTO<List<EPS>>> listarEPS(){
        return ResponseEntity.ok().body(new MensajeDTO<>(false, administradorServicio.listarEPS()));
    }

}