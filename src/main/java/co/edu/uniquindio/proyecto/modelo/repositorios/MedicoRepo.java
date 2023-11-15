package co.edu.uniquindio.proyecto.modelo.repositorios;

import co.edu.uniquindio.proyecto.modelo.entidades.Cita;
import co.edu.uniquindio.proyecto.modelo.entidades.DiaLibre;
import co.edu.uniquindio.proyecto.modelo.entidades.Medico;
import co.edu.uniquindio.proyecto.modelo.enumeracion.EstadoCita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MedicoRepo extends JpaRepository<Medico, Integer> {
    //LOS DOS PUNTOS CEDULA (:CEDULA) ES PARA COGER EL PARAMETRO DEL METODO
//    @Query("select  m from Medico m where m.cedula = :edula")
//    Medico bucarPorCedula(String cedula);

    //OTRA FOMRA PARA HACER LA CONSULTA
    Medico findByCedula(String cedula);

//    @Query("select m from Medico m where m.correo = :correo")
//    Medico buscarPorCorreo(String correo);

    ///OTRA FORMA
    Medico findByCorreo(String correo);

    @Query("select c.motivo, c.atencion.notasMedicas, c.atencion.tratamiento from Cita c where c.estado =: estado")
    List<Cita> listarCitasSegunEstado(EstadoCita estado);

    @Query(nativeQuery = true, value = "select * from dia_libre d where d.codigo_medico_codigo = :codigoMedico and date(d.dia) = date(:fechaCita)")
    List<DiaLibre> buscarDiaLibre(int codigoMedico, LocalDateTime fechaCita);
}
