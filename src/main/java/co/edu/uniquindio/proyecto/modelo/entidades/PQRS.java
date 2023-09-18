package co.edu.uniquindio.proyecto.modelo.entidades;

import co.edu.uniquindio.proyecto.modelo.enumeracion.Estado_PQRS;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
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
    private LocalDate fecha_ceacion;
    private String tipo;
    private String motivo;

    //LLAVES FORANEAS
    @ManyToOne
    private Cita codigo_cita;
    private Estado_PQRS codigo_estado;
    @OneToMany(mappedBy = "codigo_pqrs")
    private List<Mensaje> mensajeList;
}
