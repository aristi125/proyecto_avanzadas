package co.edu.uniquindio.proyecto.modelo.entidades;

import co.edu.uniquindio.proyecto.modelo.enumeracion.Estado_Cita;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
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
    private String fecha_creacion;
    private String frcha_cita;
    private String motivo;

    //LLAVES FORANEAS
    @ManyToOne
    private Paciente cedula_paciente;
    @ManyToOne
    private Medico codigo_medico;
    //PREGUNTAR COMO RELACIONARLO
    private Estado_Cita codigo_estado;
    @OneToOne(mappedBy = "codigo_cita")
    private Atencion atencion;
    @OneToMany(mappedBy = "codigo_cita")
    private List<PQRS> pqrsList;
}
