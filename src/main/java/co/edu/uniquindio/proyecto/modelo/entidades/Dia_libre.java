package co.edu.uniquindio.proyecto.modelo.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Dia_libre implements Serializable {
    //LLAVE PRIMARIA
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    private LocalDate dia;
    //LLAVES FORANEAS
    @ManyToOne
    private Medico codigo_medico;
}
