package main;

import domain.Persona;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Collection;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {

        Persona p1 = new Persona("Julio");
        Persona p2 = new Persona("Hugo");
        Persona p3 = new Persona("Raquel");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Collection<Persona> personas = new HashSet();

        personas.add(p1);
        personas.add(p2);
        personas.add(p3);

        personas.stream().forEach(a -> em.persist(a));

        em.getTransaction().commit();
        em.close();
        emf.close();

    }
}
