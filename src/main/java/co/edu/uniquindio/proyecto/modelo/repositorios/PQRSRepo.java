package co.edu.uniquindio.proyecto.modelo.repositorios;

import co.edu.uniquindio.proyecto.modelo.entidades.PQRS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PQRSRepo extends JpaRepository<PQRS, Integer> {

    @Query("select p from PQRS p where p.cita.paciente.codigo =:codigoPaciente")
    List<PQRS> listarPqrsDePaciente(int codigoPaciente);


}
