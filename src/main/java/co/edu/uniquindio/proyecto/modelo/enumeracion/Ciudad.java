package co.edu.uniquindio.proyecto.modelo.enumeracion;

import lombok.Getter;

@Getter
public enum Ciudad {
    ARMENIA ("Armenia"),
    BOGOTA ("Bogota"),
    MEDELLIN ("Medellin"),
    CALI ("Cali"),
    CARTAGENA ("Cartagena");

    private final String nombre;

    Ciudad(String nombre) {
        this.nombre = nombre;
    }

}
