package main;

import domain.Coche;
import domain.Persona;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("relacciones");
        EntityManager em = emf.createEntityManager();
/** Estamos provocando un inconsistencia, el mismo coche se indica en propietario del objeto coche que es Ana y en el
 * objeto persona de jose que le pertenece a el ¿Esto se translada a DB o JPA controla esta inconsistencia ?*/
        Persona ana = new Persona();
        ana.setNombre("Ana");
        Persona jose = new Persona();
        jose.setNombre("Jose");
        Coche mazda = new Coche();
        mazda.setPropietario(jose);
        ana.addCoche(mazda);


        em.getTransaction().begin();
        em.persist(ana);
        em.persist(jose);
        em.persist(mazda);

        em.getTransaction().commit();

        /** Refrescamos a ver que ha quedado en DB? */
        em.refresh(mazda);
        em.refresh(ana);
        em.refresh(jose);

        /** JPA salva estas inconsitencias, en DB esta bien*/
        System.out.println("coches de jose = " + jose.getListaCoches().size());
        System.out.println("coches de ana = " + ana.getListaCoches().size());
        System.out.println("mazda.getPropietario().getNombre() = " + mazda.getPropietario().getNombre());

        em.close();
        emf.close();

    }

}
