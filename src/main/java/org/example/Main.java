package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory enf = Persistence.createEntityManagerFactory("personaH2");
        EntityManager en = enf.createEntityManager();

        Persona persona = new Persona();
        persona.setNombre("María");
        persona.setApellidos("González López");
        persona.setFechaNacimiento(LocalDate.of(1985, 6, 15));
        persona.setSexo(Sexo.MUJER);
        persona.setEstadoCivil(EstadoCivil.CASADO);


        en.getTransaction().begin();
        en.persist(persona);
        en.getTransaction().commit();
    }
}