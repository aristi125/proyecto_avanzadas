package co.edu.uniquindio.proyecto.modelo.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

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
    @Column(nullable = false)
    private LocalDateTime fecha;
    @Column(nullable = false, length = 300)
    private String contenido;

    //LLAVES FORANEAS
    @ManyToOne
    private PQRS codigoPqrs;
    @ManyToOne
    private Cuenta cuenta;
    @OneToOne
    private Mensaje codigoMensaje;
}
