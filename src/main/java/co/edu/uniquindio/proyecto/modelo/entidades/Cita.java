package co.edu.uniquindio.proyecto.modelo.entidades;

import co.edu.uniquindio.proyecto.modelo.enumeracion.EstadoCita;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cita implements Serializable {
    //LLAVE PRIMARIA
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @Column(nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(nullable = false)
    private LocalDateTime fechaCita;

    @Column(nullable = false, length = 255)
    private String motivo;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EstadoCita estado;
    //LLAVES FORANEAS
    @JoinColumn(nullable = false)
    @ManyToOne
    private Paciente paciente;

    @JoinColumn(nullable = false)
    @ManyToOne
    private Medico medico;

    //@JoinColumn(nullable = false)
    @OneToOne(mappedBy = "codigoCita")
    private Atencion atencion;

    //@JoinColumn(nullable = false)
    @OneToMany(mappedBy = "cita")
    private List<PQRS> pqrsList;
}
