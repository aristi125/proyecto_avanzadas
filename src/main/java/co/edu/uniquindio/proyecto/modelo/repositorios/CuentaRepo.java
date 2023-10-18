package co.edu.uniquindio.proyecto.modelo.repositorios;

import co.edu.uniquindio.proyecto.modelo.entidades.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CuentaRepo extends JpaRepository<Cuenta, Integer> {
    Optional<Cuenta> findByCorreo(String correo);
}
