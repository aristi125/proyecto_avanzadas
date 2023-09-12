package co.edu.uniquindio.proyecto.modelo.entidades;

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
public class Medico extends Usuario implements Serializable {
    //LLAVE PRIMARIA
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    //LLAVES FORANEAS
    private Especialidad codigo_especialidad;

    @OneToMany(mappedBy ="codigo_medico" )
    private List<Cita> citaMedicoList;
    @OneToMany(mappedBy = "codigo_medico")
    private List<Dia_libre> dia_libreList;
    @OneToMany(mappedBy = "codigo_medico")
    private List<Horario> horarioList;
}
