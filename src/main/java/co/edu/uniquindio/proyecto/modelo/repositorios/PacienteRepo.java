package co.edu.uniquindio.proyecto.modelo.repositorios;

import co.edu.uniquindio.proyecto.modelo.entidades.Cita;
import co.edu.uniquindio.proyecto.modelo.entidades.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PacienteRepo extends JpaRepository<Paciente,Integer> {

    Paciente findByCorreo(String correo);

    Paciente findByCedula(String cedula);
}
