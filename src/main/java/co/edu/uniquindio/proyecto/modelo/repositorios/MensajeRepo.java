package co.edu.uniquindio.proyecto.modelo.repositorios;

import co.edu.uniquindio.proyecto.modelo.entidades.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MensajeRepo extends JpaRepository<Mensaje, Integer>  {
    //PARA LISTAR TODOS LOS MENSAJES DE LOS PQRS
    //@Query("select m.codigo, m.contenido, m.fecha from Mensaje m where m.codigoPqrs =:codigoPqrs")
    List<Mensaje> findAllByCodigoPqrsCodigo(int codigoPqrs);
}
