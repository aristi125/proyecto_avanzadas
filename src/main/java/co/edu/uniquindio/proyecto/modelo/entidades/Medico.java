package co.edu.uniquindio.proyecto.modelo.entidades;

import co.edu.uniquindio.proyecto.modelo.enumeracion.Especialidad;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.util.List;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Medico extends Usuario implements Serializable {

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Especialidad especialidad;

    //LLAVES FORANEAS
    //@JoinColumn(nullable = false)
    @OneToMany(mappedBy = "medico")
    private List<Cita> citaMedicoList;

    //@JoinColumn(nullable = false)
    @OneToMany(mappedBy = "codigoMedico")
    private List<DiaLibre> dia_libreList;

    //@JoinColumn(nullable = false)
    @OneToMany(mappedBy = "codigoMedico")
    private List<HorarioMedico> horarioMedicoList;
}
