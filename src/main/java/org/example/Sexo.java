package org.example;

public enum Sexo {
    HOMBRE("H"), MUJER("M");

    String sexoCadena;

    Sexo(){}

    Sexo(String sexoCadena) {
        this.sexoCadena = sexoCadena;
    }

    public String getSexoCadena() {
        return sexoCadena;
    }

    public void setSexoCadena(String sexoCadena) {
        this.sexoCadena = sexoCadena;
    }

    public Sexo getSexo(String sexoCadena){
        for (Sexo sex: Sexo.values()){
            if (sex.getSexoCadena().equals(sexoCadena)){
                return sex;
            }
        }

        return null;
    }

    @Override
    public String toString() {
        return "Sexo{" +
                "sexoCadena='" + sexoCadena + '\'' +
                '}';
    }
}
