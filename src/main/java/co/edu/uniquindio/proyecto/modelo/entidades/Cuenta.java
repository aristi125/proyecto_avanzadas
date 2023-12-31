package co.edu.uniquindio.proyecto.modelo.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigo;

    @Column(nullable = false, length = 100)
    private String correo;

    @Column(nullable = false, length = 200)
    private String password;

    //LLAVES FORANEAS
    //@JoinColumn(nullable = false)
    @OneToMany(mappedBy = "cuenta")
    private List<Mensaje> mensajeList;
}
