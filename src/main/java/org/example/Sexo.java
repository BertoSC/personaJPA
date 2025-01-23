package org.example;

public enum Sexo {
    HOMBRE('H'), MUJER('M');

    Character sexoCadena;

    Sexo(){}

    Sexo(Character sexoCadena) {
        this.sexoCadena = sexoCadena;
    }

    public Character getSexoCadena() {
        return sexoCadena;
    }

    public void setSexoCadena(Character sexoCadena) {
        this.sexoCadena = sexoCadena;
    }

    public Sexo getSexo(Character sexoCadena){
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
