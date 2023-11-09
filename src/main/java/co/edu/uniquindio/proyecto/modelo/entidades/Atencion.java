package co.edu.uniquindio.proyecto.modelo.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.core.codec.StringDecoder;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Atencion implements Serializable {
    //LLAVE PRIMARIA
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @Column(nullable = false, length = 200)
    private String diagnostico;

    @Column(nullable = false, length = 200)
    private String tratamiento;

    @Column(nullable = false, length = 200)
    private String notasMedicas;

    //LLAVES FORANEAS
    @JoinColumn(nullable = false)
    @OneToOne
    private Cita codigoCita;
}
