package co.edu.uniquindio.proyecto.modelo.servicios.impl;

import co.edu.uniquindio.proyecto.dto.MedicoEspecialidadDTO;
import co.edu.uniquindio.proyecto.dto.paciente.ItemCitaPendientePacienteDTO;
import co.edu.uniquindio.proyecto.modelo.entidades.Cita;
import co.edu.uniquindio.proyecto.modelo.enumeracion.Ciudad;
import co.edu.uniquindio.proyecto.modelo.enumeracion.EPS;
import co.edu.uniquindio.proyecto.modelo.enumeracion.Especialidad;
import co.edu.uniquindio.proyecto.modelo.enumeracion.TipoSangre;
import co.edu.uniquindio.proyecto.modelo.repositorios.CitaRepo;
import co.edu.uniquindio.proyecto.modelo.repositorios.ClinicaRepo;
import co.edu.uniquindio.proyecto.modelo.servicios.interfaces.ClinicaServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor // CREA EL CONSTRUCTOR DE TODOS LOS METODOS
public class ClinicaServicioImpl implements ClinicaServicio {


    //CLINICA

    //COMO SE LES PONE LA EXCEPCION ?????

    public List<Ciudad> listarCiudades(){
        return Arrays.asList(Ciudad.values());
    }


    public List<Especialidad> listarEspecialidadesMedico(){
        return Arrays.asList(Especialidad.values());
    }


    public List<EPS> listarEPS() {
        return Arrays.asList(EPS.values());
    }
    public List<TipoSangre> listarTipoSangre(){
        return Arrays.asList(TipoSangre.values());
    }


}
