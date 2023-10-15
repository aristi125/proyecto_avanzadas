package co.edu.uniquindio.proyecto.modelo.entidades;

import co.edu.uniquindio.proyecto.modelo.enumeracion.EPS;
import co.edu.uniquindio.proyecto.modelo.enumeracion.EstadoCita;
import co.edu.uniquindio.proyecto.modelo.enumeracion.TipoSangre;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
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
    private LocalDateTime fechaCreacionCita;
    private String alergias;

    //LLAVES FORANEAS
    private EPS eps;
    private EstadoCita estadoCita;
    @Column(nullable = false)
    private TipoSangre tipoSangre;
    @OneToMany(mappedBy = "paciente")
    private List<Cita> citaPacienteList;

    @Override
    public String toString() {
        return "Paciente{" +
                "fechaNacimiento=" + fechaNacimiento +
                ", fechaCreacionCita=" + fechaCreacionCita +
                ", alergias='" + alergias + '\'' +
                ", eps=" + eps +
                ", estadoCita=" + estadoCita +
                ", tipoSangre=" + tipoSangre +
                ", citaPacienteList=" + citaPacienteList +
                '}';
    }
}
