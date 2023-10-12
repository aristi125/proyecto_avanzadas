package co.edu.uniquindio.proyecto.modelo.repositorios;

import co.edu.uniquindio.proyecto.modelo.entidades.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

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
}
