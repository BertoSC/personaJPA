package org.example;

public enum EstadoCivil {
    SOLTERO("Soltero"), CASADO("Casado"), DIVORCIADO("Divorciado"), VIUDO("Viudo");

    String estadoCivil;

    EstadoCivil(String estado){
        this.estadoCivil=estado;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public EstadoCivil getEstadoCivil(String estadoCivil){
        for (EstadoCivil est:EstadoCivil.values()){
            if (est.getEstadoCivil().equals(estadoCivil)){
                return est;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "EstadoCivil{" +
                "estadoCivil='" + estadoCivil + '\'' +
                '}';
    }
}
