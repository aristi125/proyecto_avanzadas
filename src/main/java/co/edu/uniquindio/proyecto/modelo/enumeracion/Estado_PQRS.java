package co.edu.uniquindio.proyecto.modelo.enumeracion;

public enum Estado_PQRS {
    APROBADO ("Aprobado"),
    RECHAZADO ("Rechazado"),
    EN_PROCESO ("En proceso"),
    FINALIZADO ("Finalizado");

    private final String estadoPQR;

    Estado_PQRS(String estadoPQR) {
        this.estadoPQR = estadoPQR;
    }

    public String getEstadoPQR() {
        return estadoPQR;
    }
}
