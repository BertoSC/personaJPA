package org.example;

import jakarta.persistence.AttributeConverter;

public class ConvertidorSexo implements AttributeConverter <Sexo, Character> {
    @Override
    public Character convertToDatabaseColumn(Sexo sexo) {
        if (sexo!=null){
            return sexo.getSexoCadena();
        } else {
            return null;
        }
    }

    @Override
    public Sexo convertToEntityAttribute(Character character) {
        for (Sexo sex: Sexo.values()){
            if (sex.getSexoCadena().equals(character)){
                return sex;
            }
        }

        return null;
    }
}
