package main;

import domain.Persona;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("seccion4");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Persona Julio = new Persona("Julio");
        em.persist(Julio);
        em.getTransaction().commit();
        Persona JulioDB = em.find(Persona.class,"Julio");
        Persona Julio2 = new Persona("Julio");
        Persona lazyLoading = em.getReference(Persona.class,"Julio");

        Comparator porNombre = Comparator.comparing(Persona::getNombre);

        System.out.println(" = " + porNombre.compare(Julio2,JulioDB));

        System.out.println("lazyLoading.equals(Julio2); = " + lazyLoading.equals(Julio2));

        em.close();
        emf.close();


    }
}
