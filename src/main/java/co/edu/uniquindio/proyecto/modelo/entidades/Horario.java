package co.edu.uniquindio.proyecto.modelo.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Horario implements Serializable {
    //LLAVE PRIMARIA
    @Id
    private int codigo;
    private String dia;
    private LocalDateTime hora_inicio;
    private LocalDateTime hora_fin;

    //LLAVES FORANEAS
    @ManyToOne
    private Medico codigo_medico;
}
