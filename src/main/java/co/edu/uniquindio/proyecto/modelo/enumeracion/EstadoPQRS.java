package co.edu.uniquindio.proyecto.modelo.enumeracion;

public enum EstadoPQRS {
    APROBADO ("Aprobado"),
    RECHAZADO ("Rechazado"),
    EN_PROCESO ("En proceso"),
    FINALIZADO ("Finalizado");

    private final String estadoPQR;

    EstadoPQRS(String estadoPQR) {
        this.estadoPQR = estadoPQR;
    }

    public String getEstadoPQR() {
        return estadoPQR;
    }
}
