package co.edu.uniquindio.proyecto.modelo.enumeracion;

import lombok.Getter;

@Getter
public enum Especialidad {
    CARDIOLGIA ("Cardiologia"),
    NEUTROLOGIA ("Neurologia"),
    PEDIATRA ("Pedriata"),
    ONCOLOGIA ("Oncologia"),
    ORTOPEDIA ("Ortopedia"),
    CIRUJANO_PLASTICO ("Cirujano plastico");

    private final String especialidad;

    Especialidad(String especialidad) {
        this.especialidad = especialidad;
    }

}
