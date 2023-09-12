package co.edu.uniquindio.proyecto.modelo.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Mensaje implements Serializable {
    //LLAVE PRIMARIA
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    private String fecha_creacion;
    private String mensaje;

    //LLAVES FORANEAS
    @ManyToOne
    private PQRS codigo_pqrs;
    @ManyToOne
    private Cuenta cuenta_codigo;
    @OneToOne
    private Mensaje codigo_mensaje;
}
