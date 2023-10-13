package co.edu.uniquindio.proyecto.modelo.servicios.impl;

import co.edu.uniquindio.proyecto.dto.medico.AtenderConsultaPacienteDTO;
import co.edu.uniquindio.proyecto.dto.medico.DiaLibreDTO;
import co.edu.uniquindio.proyecto.dto.medico.ItemCitasActualDTOMedico;
import co.edu.uniquindio.proyecto.dto.medico.ItemCitasPendienteDTOMedico;
import co.edu.uniquindio.proyecto.modelo.entidades.*;
import co.edu.uniquindio.proyecto.modelo.enumeracion.EstadoCita;
import co.edu.uniquindio.proyecto.modelo.repositorios.*;
import co.edu.uniquindio.proyecto.modelo.servicios.interfaces.MedicoServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor // CREA EL CONSTRUCTOR DE TODOS LOS METODOS
public class MedicoServicioImpl implements MedicoServicio {
    private final PacienteRepo pacienteRepo;
    private  final CitaRepo citaRepo;
    private final MedicoRepo medicoRepo;
    private final AtencionRepo atencionRepo;
    private final DiaLibreRepo diaLibreRepo;

    //========================================
    @Override
    public List<ItemCitasPendienteDTOMedico> listarCitasPendientes(int codigo) throws Exception {
        List<Cita> citas = citaRepo.obtenerCitasMedico(codigo, EstadoCita.ATENTIDO);
        if (citas.isEmpty()){
            throw new Exception("No hay citas registradas");
        }
        List<ItemCitasPendienteDTOMedico> respuesta = new ArrayList<>();
        for (Cita c: citas){
            respuesta.add(new ItemCitasPendienteDTOMedico(
                    c.getCodigo(),
                    c.getPaciente().getCedula(),
                    c.getPaciente().getNombre(),
                    c.getPaciente().getUrlFoto(),
                    c.getFechaCita(),
                    c.getPaciente().getCodigoEps(),
                    c.getEstado()
            ));
        }
        return respuesta;
    }

    @Override
    public int atenderCitas(AtenderConsultaPacienteDTO dto) throws Exception {
        Optional<Cita> opcional = citaRepo.findById(dto.codigoCita());
        if (opcional.isEmpty()) {
            throw new Exception("No existe un paciente con el codigo " + dto.codigoCita());
        }

        Cita cita = opcional.get();
        Atencion atencion = new Atencion();

        if (cita.getFechaCita().isEqual(LocalDateTime.now())){
            atencion.setCodigoCita(cita);
            atencion.setDiagnostico(dto.diagnostico());
            atencion.setNotasMedicas(dto.notas());
            atencion.setTratamiento(dto.tratamiento());

            return atencionRepo.save(atencion).getCodigo();
        }

        throw new Exception("No puede atender citas que sean de otro día");
    }

    @Override
    public List<ItemCitasPendienteDTOMedico> listasCitasPaciente() throws Exception {
        return null;
    }

    @Override
    public void agendarDiaLibre(DiaLibreDTO diaLibreDTO) throws Exception {
        List<Cita> citasProgramadas = citaRepo.obtenerCitasMedico(diaLibreDTO.codigo(), diaLibreDTO.diaLibre());
        Optional<Medico> optional = medicoRepo.findById(diaLibreDTO.codigo());

        if(citasProgramadas.size() > 0){
            throw new Exception("No se puede agendar este día porque ya tiene citas");
        }else{

            DiaLibre diaLibre = new DiaLibre();
            diaLibre.setDia(diaLibreDTO.diaLibre());
            diaLibre.setCodigoMedico(optional.get());

            diaLibreRepo.save(diaLibre);
        }



    }

    @Override
    public List<Cita> listarCitasPorEstado(EstadoCita estado) throws Exception{
        return null;
    }


}
