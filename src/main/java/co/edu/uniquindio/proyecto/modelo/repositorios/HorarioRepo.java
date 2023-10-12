package co.edu.uniquindio.proyecto.modelo.repositorios;

import co.edu.uniquindio.proyecto.modelo.entidades.HorarioMedico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HorarioRepo extends JpaRepository<HorarioMedico, Integer> {
    //PARA MOSTRAR TODOS EL HORARIO DEL MEDICO
    List<HorarioMedico> findAllByCodigo(int codigo);
}
