package co.edu.uniquindio.proyecto.modelo.entidades;

import co.edu.uniquindio.proyecto.modelo.enumeracion.EPS;
import co.edu.uniquindio.proyecto.modelo.enumeracion.EstadoCita;
import co.edu.uniquindio.proyecto.modelo.enumeracion.TipoSangre;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
public class Paciente extends Usuario implements Serializable {
    //LLAVE PRIMARIA

    private LocalDateTime fechaNacimiento;
    private LocalDateTime fechaCreacionCita;
    private String alergias;

    //LLAVES FORANEAS
    private EPS codigoEps;
    private EstadoCita estadoCita;
    @Column(nullable = false)
    private TipoSangre codigoTipoSangre;
    @OneToMany(mappedBy = "paciente")
    private List<Cita> citaPacienteList;


}
