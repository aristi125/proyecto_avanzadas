package co.edu.uniquindio.proyecto.controladores;


import co.edu.uniquindio.proyecto.dto.LoginDTO;
import co.edu.uniquindio.proyecto.dto.MensajeDTO;
import co.edu.uniquindio.proyecto.dto.TokenDTO;
import co.edu.uniquindio.proyecto.dto.paciente.RegistroPacienteDTO;
import co.edu.uniquindio.proyecto.modelo.servicios.interfaces.AutenticacionServicio;
import co.edu.uniquindio.proyecto.modelo.servicios.interfaces.PacienteServicio;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AutenticacionController {
    private final AutenticacionServicio autenticacionServicio;
    private final PacienteServicio pacienteServicio;
    @PostMapping("/login")
    public ResponseEntity<MensajeDTO<TokenDTO>> login(@Valid @RequestBody LoginDTO loginDTO)
            throws Exception {
        TokenDTO tokenDTO = autenticacionServicio.login(loginDTO);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, tokenDTO));
    }

    @PostMapping("/registrar")
    public ResponseEntity<MensajeDTO<String>> registrarse(@Valid @RequestBody RegistroPacienteDTO registroPacienteDTO) throws Exception{
        pacienteServicio.registrarse(registroPacienteDTO);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, "Se registro correctamente el paciente"));
    }
}
