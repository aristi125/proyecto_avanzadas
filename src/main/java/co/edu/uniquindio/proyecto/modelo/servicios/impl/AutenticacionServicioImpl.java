package co.edu.uniquindio.proyecto.modelo.servicios.impl;

import co.edu.uniquindio.proyecto.dto.LoginDTO;
import co.edu.uniquindio.proyecto.dto.TokenDTO;
import co.edu.uniquindio.proyecto.modelo.entidades.Cuenta;
import co.edu.uniquindio.proyecto.modelo.entidades.Medico;
import co.edu.uniquindio.proyecto.modelo.entidades.Paciente;
import co.edu.uniquindio.proyecto.modelo.repositorios.CuentaRepo;
import co.edu.uniquindio.proyecto.modelo.servicios.interfaces.AutenticacionServicio;
import co.edu.uniquindio.proyecto.utils.JWTUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
@RequiredArgsConstructor
public class AutenticacionServicioImpl implements AutenticacionServicio {
    private final CuentaRepo cuentaRepo;
    private final JWTUtils jwtUtils;
    @Override
    public TokenDTO login(LoginDTO loginDTO) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        Optional<Cuenta> cuentaOptional = cuentaRepo.findByCorreo(loginDTO.correo());
        if(cuentaOptional.isEmpty()){
            throw new Exception("No existe el correo ingresado");
        }
        Cuenta cuenta = cuentaOptional.get();
        if( !passwordEncoder.matches(loginDTO.password(), cuenta.getPassword()) ){
            throw new Exception("La contraseña ingresada es incorrecta");
        }
        return new TokenDTO( crearToken(cuenta) );
    }

    private boolean estaRepetidoCorreo(String correo) {
        return !(cuentaRepo.findByCorreo(correo) != null);
    }

    private String crearToken(Cuenta cuenta){
        String rol;
        String nombre;
        if( cuenta instanceof Paciente){
            rol = "paciente";
            nombre = ((Paciente) cuenta).getNombre();
        }else if( cuenta instanceof Medico){
            rol = "medico";
            nombre = ((Medico) cuenta).getNombre();
        }else{
            rol = "admin";
            nombre = "Administrador";
        }
        Map<String, Object> map = new HashMap<>();
        map.put("rol", rol);
        map.put("nombre", nombre);
        map.put("id", cuenta.getCodigo());
        return jwtUtils.generarToken(cuenta.getCorreo(), map);
    }
}
