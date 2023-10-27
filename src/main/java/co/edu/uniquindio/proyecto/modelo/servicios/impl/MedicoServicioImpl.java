package co.edu.uniquindio.proyecto.modelo.servicios.impl;

import co.edu.uniquindio.proyecto.dto.medico.*;
import co.edu.uniquindio.proyecto.modelo.entidades.*;
import co.edu.uniquindio.proyecto.modelo.enumeracion.EstadoCita;
import co.edu.uniquindio.proyecto.modelo.repositorios.*;
import co.edu.uniquindio.proyecto.modelo.servicios.interfaces.MedicoServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor // CREA EL CONSTRUCTOR DE TODOS LOS METODOS
public class MedicoServicioImpl implements MedicoServicio {
    @Autowired
    private final PacienteRepo pacienteRepo;
    @Autowired
    private  final CitaRepo citaRepo;
    @Autowired
    private final MedicoRepo medicoRepo;
    @Autowired
    private final AtencionRepo atencionRepo;
    @Autowired
    private final DiaLibreRepo diaLibreRepo;

    //========================================
    @Override
    public List<ItemCitasPendienteDTOMedico> listarCitasPendientes(int codigo) throws Exception {

        List<Cita> citas = citaRepo.obtenerCitasMedico(codigo, EstadoCita.PROGRAMADA);

        List<ItemCitasPendienteDTOMedico> respuesta = new ArrayList<>();

        for (Cita c: citas){

            respuesta.add(new ItemCitasPendienteDTOMedico(
                    c.getCodigo(),
                    c.getPaciente().getCedula(),
                    c.getPaciente().getNombre(),
                    c.getPaciente().getUrlFoto(),
                    c.getFechaCita(),
                    c.getPaciente().getEps(),
                    c.getEstado()));

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

        if (LocalDate.from(cita.getFechaCita()).isEqual(LocalDate.now())){

            atencion.setCodigoCita(cita);
            atencion.setDiagnostico(dto.diagnostico());
            atencion.setNotasMedicas(dto.notas());
            atencion.setTratamiento(dto.tratamiento());

            return atencionRepo.save(atencion).getCodigo();

        } else {
            throw new Exception("No puede atender citas que sean de otro día");
        }

    }

    @Override
    public List<HistorialPacienteDTO> listasUnaCitasPaciente(int codigo) throws Exception {

        List<Cita> citasHistorial = citaRepo.obtenerHistorialPaciente(codigo);
        Optional<Paciente> opcional = pacienteRepo.findById(codigo);

        if (citasHistorial.isEmpty()){
            throw new Exception("El paciente con el codigo "+codigo+" no a registrado citas");
        }

        Paciente paciente = opcional.get();
        List<HistorialPacienteDTO> respuesta = new ArrayList<>();

            for (Cita c : citasHistorial) {
                respuesta.add(new HistorialPacienteDTO(
                        c.getCodigo(),
                        c.getPaciente().getNombre(),
                        c.getPaciente().getCedula(),
                        c.getAtencion().getTratamiento(),
                        c.getAtencion().getDiagnostico(),
                        c.getAtencion().getNotasMedicas(),
                        c.getMotivo()));

            }

        return respuesta;

    }

    @Override
    public int agendarDiaLibre(DiaLibreDTO diaLibreDTO) throws Exception {

        List<Cita> citasProgramadas = citaRepo.obtenerCitasMedico(diaLibreDTO.codigo(), diaLibreDTO.diaLibre());
        Optional<Medico> optional = medicoRepo.findById(diaLibreDTO.codigo());

        if(optional.isEmpty() ){
            throw new Exception("No existe un médico con el código "+diaLibreDTO.codigo());
        }

        //Solo puede haber un día libre activo

        if(!citasProgramadas.isEmpty()){
            throw new Exception("No se puede agendar este día porque ya tiene citas");
        }else{

            DiaLibre diaLibre = new DiaLibre();
            diaLibre.setDia(diaLibreDTO.diaLibre());
            diaLibre.setCodigoMedico(optional.get());

            return diaLibreRepo.save(diaLibre).getCodigo();
        }

    }

    @Override
    public List<HistorialPacienteDTO> listarTodasCitasPacientes(int codigo) throws Exception {

        //List<Cita> citasHistorial = citaRepo.obtenerHistorialPaciente(codigo, EstadoCita.COMPLETA);
        Optional<Paciente> opcional = pacienteRepo.findById(codigo);
        List<Cita> citasHistorial= citaRepo.obtenerHistorialPaciente(codigo);

        if (citasHistorial.isEmpty()){
            throw new Exception("El paciente con el codigo "+codigo+" no a registrado citas");
        }

        Paciente paciente = opcional.get();
        List<HistorialPacienteDTO> respuesta = new ArrayList<>();

        for (Cita c : citasHistorial) {

            respuesta.add(new HistorialPacienteDTO(
                    c.getCodigo(),
                    c.getPaciente().getNombre(),
                    c.getPaciente().getCedula(),
                    c.getAtencion().getTratamiento(),
                    c.getAtencion().getDiagnostico(),
                    c.getAtencion().getNotasMedicas(),
                    c.getMotivo()));

        }

        return respuesta;
    }


}
