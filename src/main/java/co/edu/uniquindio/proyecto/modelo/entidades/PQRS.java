package co.edu.uniquindio.proyecto.modelo.entidades;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.repository.cdi.Eager;

import java.io.Serializable;
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
    private String fecha_ceacion;
    private String tipo;
    private String motivo;

    //LLAVES FORANEAS
    @ManyToOne
    private Cita codigo_cita;
    private Estado_PQRS codigo_estado;
    @OneToMany(mappedBy = "codigo_pqrs")
    private List<Mensaje> mensajeList;
}
