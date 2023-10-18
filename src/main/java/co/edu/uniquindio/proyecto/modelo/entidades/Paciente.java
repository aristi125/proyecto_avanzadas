package co.edu.uniquindio.proyecto.modelo.entidades;

import co.edu.uniquindio.proyecto.modelo.enumeracion.EPS;
import co.edu.uniquindio.proyecto.modelo.enumeracion.EstadoCita;
import co.edu.uniquindio.proyecto.modelo.enumeracion.TipoSangre;
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
public class Paciente extends Usuario implements Serializable {
    //LLAVE PRIMARIA

    private LocalDate fechaNacimiento;
    private String alergias;

    //LLAVES FORANEAS
    @Enumerated(EnumType.STRING)
    private EPS eps;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoSangre tipoSangre;
    @OneToMany(mappedBy = "paciente")
    private List<Cita> citaPacienteList;

}
