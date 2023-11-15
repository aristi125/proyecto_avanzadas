package co.edu.uniquindio.proyecto.modelo.repositorios;

import co.edu.uniquindio.proyecto.modelo.entidades.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClinicaRepo extends JpaRepository<Cita,Integer>  {
}
