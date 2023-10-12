package co.edu.uniquindio.proyecto.modelo.entidades;

import co.edu.uniquindio.proyecto.modelo.enumeracion.Especialidad;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Medico extends Usuario implements Serializable {

    //LLAVES FORANEAS
    private Especialidad especialidad;

    @OneToMany(mappedBy = "medico")
    private List<Cita> citaMedicoList;
    @OneToMany(mappedBy = "codigoMedico")
    private List<DiaLibre> dia_libreList;
    @OneToMany(mappedBy = "codigoMedico")
    private List<HorarioMedico> horarioMedicoList;
}
