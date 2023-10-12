package co.edu.uniquindio.proyecto.modelo.entidades;

import co.edu.uniquindio.proyecto.modelo.enumeracion.EstadoPQRS;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PQRS implements Serializable {
    //LLAVE PRIMARIA
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    @Column(nullable = false)
    private LocalDateTime fechaCreacion;
    @Column(nullable = false, length = 50)
    private String tipo;
    @Column(nullable = false, length = 300)
    private String motivo;

    //LLAVES FORANEAS
    @ManyToOne
    private Cita cita;
    private EstadoPQRS estado;
    @OneToMany(mappedBy = "codigoPqrs")
    private List<Mensaje> mensajeList;
}
