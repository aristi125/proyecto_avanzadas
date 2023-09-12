package co.edu.uniquindio.proyecto.modelo.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
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
