package org.formacion.jpa.main;

import org.formacion.jpa.domain.Persona;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_main");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Persona julio = new Persona();
        julio.setNombre("Julio");


        em.persist(julio);
        em.getTransaction().commit();
        em.close();

        emf.close();



    }
}
