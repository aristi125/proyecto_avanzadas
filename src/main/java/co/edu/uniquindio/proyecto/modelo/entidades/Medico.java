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
    private Especialidad codigo_especialidad;

    @OneToMany(mappedBy ="codigo_medico" )
    private List<Cita> citaMedicoList;
    @OneToMany(mappedBy = "codigo_medico")
    private List<Dia_libre> dia_libreList;
    @OneToMany(mappedBy = "codigo_medico")
    private List<Horario> horarioList;
}
