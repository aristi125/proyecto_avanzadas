package co.edu.uniquindio.proyecto.modelo.repositorios;

import co.edu.uniquindio.proyecto.modelo.entidades.Cita;
import co.edu.uniquindio.proyecto.modelo.enumeracion.Especialidad;
import co.edu.uniquindio.proyecto.modelo.enumeracion.EstadoCita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.AbstractQueue;
import java.util.List;

@Repository
public interface CitaRepo extends JpaRepository<Cita,Integer> {

    @Query("select c from Cita c where c.paciente.codigo =:paciente and c.estado = co.edu.uniquindio.proyecto.modelo.enumeracion.EstadoCita.COMPLETA")
    List<Cita> obtenerHistorialPaciente(int paciente);

    @Query("select c  from Cita c where c.medico.codigo =:codigoMedico")
    List<Cita> obtenerHistorialAtencionPorMedico(int codigoMedico);

    @Query("select c from Cita c where c.medico.codigo = :codigo and c.estado <> :estadoCita")
    List<Cita> obtenerCitasMedico(@Param("codigo") int codigo, @Param("estadoCita") EstadoCita estadoCita);

    @Query("select c from Cita c where c.medico.codigo = :codigo and date(c.fechaCita) = :fecha")
    List<Cita> obtenerCitasMedico(int codigo, LocalDate fecha);

    @Query("select c from Cita c where c.paciente.codigo = :codigoPaciente and date(c.fechaCita) = :fecha")
    List<Cita> obtenerCitasFecha(int codigoPaciente, LocalDate fecha);

    @Query("select c from Cita c where c.paciente.codigo = :codigoPaciente and c.medico.nombre = :nombreMedico")
    List<Cita> obtenerCitasNombreMedico(int codigoPaciente, String nombreMedico);

    @Query("select  c from Cita c where c.paciente.codigo = :codigoPaciente and c.medico.especialidad = :especialidad")
    List<Cita> listarMedicosEspecialidad(int codigoPaciente, Especialidad especialidad);
}
