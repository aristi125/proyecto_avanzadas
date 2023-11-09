package co.edu.uniquindio.proyecto.modelo.servicios.interfaces;

import co.edu.uniquindio.proyecto.dto.*;
import co.edu.uniquindio.proyecto.dto.admin.DetalleMedicoDTO;
import co.edu.uniquindio.proyecto.dto.admin.ItemCitaDTOAdmin;
import co.edu.uniquindio.proyecto.dto.admin.ItemMedicoDTO;
import co.edu.uniquindio.proyecto.dto.admin.RegistroMedicoDTO;
import co.edu.uniquindio.proyecto.modelo.enumeracion.Ciudad;
import co.edu.uniquindio.proyecto.modelo.enumeracion.EPS;
import co.edu.uniquindio.proyecto.modelo.enumeracion.Especialidad;
import co.edu.uniquindio.proyecto.modelo.enumeracion.EstadoPQRS;

import java.util.List;

public interface AdministradorServicio {
    //crearExceptions personalidazados

    int crearMedico(RegistroMedicoDTO medicoDTO) throws Exception;
    int actualizarMedico(DetalleMedicoDTO medicoDTO) throws Exception;
    void eliminarMedico (int codigo) throws Exception;
    List<ItemMedicoDTO> listarMedico () throws Exception;
    DetalleMedicoDTO obtenerMedico (int codigo) throws Exception;
    List<ItemPQRSDTO> listarPQRS () throws Exception;
    DetallePQRSDTO verDetallePQRS(int codigo) throws Exception;
    int responderPQRS(RegistroRespuestaDTO registroRespuestaDTO) throws Exception;
    void cambiarEstadoPQRS(int codigoPQRS, EstadoPQRS estadoPQRS) throws Exception;
    List<ItemCitaDTOAdmin> listarCitas () throws Exception;
    List<Ciudad> listarCiudades();
    List<Especialidad> listarEspecialidadesMedico();
    List<EPS> listarEPS();
}
