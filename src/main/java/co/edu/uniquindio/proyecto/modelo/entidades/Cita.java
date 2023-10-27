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

    private LocalDateTime fechaCreacion;

    private LocalDateTime fechaCita;

    private String motivo;

    //LLAVES FORANEAS
    @ManyToOne
    private Paciente paciente;
    @ManyToOne
    private Medico medico;
    //PREGUNTAR COMO RELACIONARLO
    @Enumerated(EnumType.STRING)
    private EstadoCita estado;
    @OneToOne(mappedBy = "codigoCita")
    private Atencion atencion;
    @OneToMany(mappedBy = "cita")
    private List<PQRS> pqrsList;
}
