package main;


import domain.Persona;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("lazy-loading");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Persona Julio = new Persona("Julio" , "Futbol");

        em.persist(Julio);
        em.getTransaction().commit();

        /** Consulta lazy a la DB, hasta que no se pregunte por un atributo que no sea la clave no se ejecuta la select*/
        /** si se hace un consulta sin resultado con este metodo lazy, dara error no controlado */
        Persona consulta = em.getReference(Persona.class,"Julio");

        /** el acceso a db se hace en esta linea */
        System.out.println("consulta.getAficion() = " + consulta.getAficion());


        em.close();
        emf.close();

    }


}
