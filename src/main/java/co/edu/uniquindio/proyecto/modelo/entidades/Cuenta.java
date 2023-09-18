package co.edu.uniquindio.proyecto.modelo.entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Cuenta implements Serializable {
    //LLAVE PRIMARIA
    @Id
    private int codigo;

    private String correo;
    private String password;

    //LLAVES FORANEAS
    @OneToMany(mappedBy = "cuenta_codigo")
    private List<Mensaje> mensajeList;
}
