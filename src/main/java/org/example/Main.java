package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory enf = Persistence.createEntityManagerFactory("personaH2");
        EntityManager en = enf.createEntityManager();

        Persona prueba = new Persona("Pepiño", "Garsía Suárez");

        en.getTransaction().begin();
        en.persist(prueba);
        en.getTransaction().commit();
    }
}