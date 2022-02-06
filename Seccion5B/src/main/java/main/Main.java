package main;

import domain.Persona;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/** carga EAGER por defecto al ser @ManyToOne usando persist y find*/
public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("recursividadEnDB");
        EntityManager em = emf.createEntityManager();

        Persona hijo = new Persona("Hugo");
        Persona padre = new Persona("Julio");
        Persona abuelo = new Persona("Casimiro");

        padre.setPadre(abuelo);
        hijo.setPadre(padre);

        em.getTransaction().begin();
        em.persist(abuelo);
        em.persist(padre);
        em.persist(hijo);


        //** Se ejecutaran todas las select outer join hasta llegar a la persona null del abuelo
        em.find(Persona.class,3L);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }

}
