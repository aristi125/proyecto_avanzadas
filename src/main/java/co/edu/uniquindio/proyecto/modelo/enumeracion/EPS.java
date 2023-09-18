package co.edu.uniquindio.proyecto.modelo.enumeracion;

public enum EPS {
    NUEVA_EPS ("Nueva eps"),
    SURA_EPS ("Sura"),
    COOMEVA_EPS ("Coomeva"),
    ASMET_SALD_EPS ("Asmet saud"),
    SANITAS_EPS ("Sanitas");

    private final String eps;

    EPS(String eps) {
        this.eps = eps;
    }

    public String getEps() {
        return eps;
    }
}
