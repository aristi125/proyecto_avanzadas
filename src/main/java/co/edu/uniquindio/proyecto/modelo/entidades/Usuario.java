package co.edu.uniquindio.proyecto.modelo.entidades;

import co.edu.uniquindio.proyecto.modelo.enumeracion.Ciudad;
import co.edu.uniquindio.proyecto.modelo.enumeracion.Especialidad;
import co.edu.uniquindio.proyecto.modelo.enumeracion.Estado;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Usuario extends Cuenta implements Serializable {
    @Column(nullable = false, length = 10)
    private String cedula;
    @Column(nullable = false, length = 50)
    private String nombre;
    @Column(nullable = false, length = 10)
    private String telefono;
    @Column(nullable = false)
    private String urlFoto;
    @Enumerated(EnumType.STRING)
    private Estado estadoUsuario;

    //LLAVES FORANEAS
    @Enumerated(EnumType.STRING)
    private Ciudad ciudad;
}
