package co.edu.uniquindio.proyecto.modelo.repositorios;

import co.edu.uniquindio.proyecto.modelo.entidades.Cita;
import co.edu.uniquindio.proyecto.modelo.enumeracion.EstadoCita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CitaRepo extends JpaRepository<Cita,Integer> {

    @Query("select c.atencion.diagnostico, c.atencion.notasMedicas, c.motivo, c.atencion.tratamiento from Cita c where c.paciente.codigo =:paciente")
    List<Cita> obtenerHistorialPaciente(int paciente);

    @Query("select c.atencion.diagnostico, c.atencion.notasMedicas, c.motivo, c.atencion.tratamiento  from Cita c where c.medico.codigo =:codigoMedico")
    List<Cita> obtenerHistorialAtencionPorMedico(int codigoMedico);

    @Query("select c from Cita c where c.medico.codigo = :codigo and c.estado <> :estado")
    List<Cita> obtenerCitasMedico(int codigo, EstadoCita estadoCita);


    @Query("select c from Cita c where c.medico.codigo = :codigo and c.fechaCita = :fecha")
    List<Cita> obtenerCitasMedico(int codigo, LocalDate fecha);

}
