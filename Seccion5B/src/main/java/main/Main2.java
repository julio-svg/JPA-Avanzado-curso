package main;

import domain.Persona;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/** carga EAGER por defecto al ser @ManyToOne usando nativeQuery*/
public class Main2 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("recursividadEnDB");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.createNativeQuery("Insert into PERSONA (nombre , padre_id) values ('casimiro' , null)").executeUpdate();
        em.createNativeQuery("Insert into PERSONA (nombre , padre_id) values ('Julio' , 1)").executeUpdate();
        em.createNativeQuery("Insert into PERSONA (nombre , padre_id) values ('Hugo' , 2)").executeUpdate();
        em.createNativeQuery("Insert into PERSONA (nombre , padre_id) values ('nieto' , 3)").executeUpdate();
        em.createNativeQuery("Insert into PERSONA (nombre , padre_id) values ('bisnieto' , 4)").executeUpdate();

        em.getTransaction().commit();

        List resultados = em.createNativeQuery("select id , nombre , padre_id from PERSONA where id = :id",Persona.class)
                .setParameter("id",3)
                .getResultList();

        resultados.stream().forEach(a -> System.out.println("Persona = " + a.toString()));

        em.close();
        emf.close();
    }
}
