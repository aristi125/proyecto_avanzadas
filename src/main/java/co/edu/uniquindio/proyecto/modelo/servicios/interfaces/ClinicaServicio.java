package co.edu.uniquindio.proyecto.modelo.servicios.interfaces;

import co.edu.uniquindio.proyecto.modelo.enumeracion.Ciudad;
import co.edu.uniquindio.proyecto.modelo.enumeracion.EPS;
import co.edu.uniquindio.proyecto.modelo.enumeracion.Especialidad;
import co.edu.uniquindio.proyecto.modelo.enumeracion.TipoSangre;

import java.util.List;

public interface ClinicaServicio {
    List<Ciudad> listarCiudades();
    List<Especialidad> listarEspecialidadesMedico();
    List<EPS> listarEPS();

    List<TipoSangre> listarTipoSangre();
}
