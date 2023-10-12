package co.edu.uniquindio.proyecto.modelo.servicios.interfaces;

public interface MedicoServicio {
    void listarCitasPendientes();
    void atenderCitas();
    void listasCitasPaciente(); //historial medico
    void agendarDiaLibre();
    void listarCitasRealizadas();
}
