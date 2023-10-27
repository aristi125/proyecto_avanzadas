package co.edu.uniquindio.proyecto.modelo.entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public class Cuenta implements Serializable {
    //LLAVE PRIMARIA
    @Id
    private int codigo;
    @Column(nullable = false, length = 100)
    private String correo;
    @Column(nullable = false, length = 200)
    private String password;

    //LLAVES FORANEAS
    @OneToMany(mappedBy = "cuenta")
    private List<Mensaje> mensajeList;
}
