package main;

import domain.Coche;
import domain.Persona;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cascade");
        EntityManager em = emf.createEntityManager();

        Coche coche = new Coche();
        Persona persona = new Persona();
        persona.setNombre("Julio");
        coche.setPropietario(persona);

        em.getTransaction().begin();

        em.persist(coche);

        em.getTransaction().commit();

        em.close();
        emf.close();

    }
}
