package co.edu.uniquindio.proyecto.modelo.entidades;

import co.edu.uniquindio.proyecto.modelo.enumeracion.Ciudad;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Usuario extends Cuenta implements Serializable {

    private String cedula;
    private String nombre;
    private int telefono;
    private String url_foto;

    //LLAVES FORANEAS
    private Ciudad codigo_ciudad;
}
