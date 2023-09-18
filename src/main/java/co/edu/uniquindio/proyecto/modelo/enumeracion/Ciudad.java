package co.edu.uniquindio.proyecto.modelo.enumeracion;

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

    public String getNombre() {
        return nombre;
    }
}
