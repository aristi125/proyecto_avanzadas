package co.edu.uniquindio.proyecto.modelo.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
public class Paciente extends Usuario implements Serializable {
    //LLAVE PRIMARIA
    @Id
    private String codigo;
    private LocalDateTime fecha_nacimiento;
    private String alergias;

    //LLAVES FORANEAS
    private EPS codigo_epes;
    private Tipo_Sangre codigo_tipo_sangre;
    @OneToMany(mappedBy = "cedula_paciente")
    private List<Cita> citaPacienteList;


}
