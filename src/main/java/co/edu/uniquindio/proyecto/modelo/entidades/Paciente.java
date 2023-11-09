package co.edu.uniquindio.proyecto.modelo.entidades;

import co.edu.uniquindio.proyecto.modelo.enumeracion.EPS;
import co.edu.uniquindio.proyecto.modelo.enumeracion.EstadoCita;
import co.edu.uniquindio.proyecto.modelo.enumeracion.TipoSangre;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
    @Column(nullable = false)
    private LocalDate fechaNacimiento;

    @Column(nullable = false)
    private String alergias;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EPS eps;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoSangre tipoSangre;

    //LLAVES FORANEAS
    @JoinColumn(nullable = false)
    @OneToMany(mappedBy = "paciente")
    private List<Cita> citaPacienteList;

}
