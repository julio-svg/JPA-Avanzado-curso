package com.example.jpaconsrping;

import com.example.jpaconsrping.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class Servicio {

    @PersistenceContext /** cumple la misma funcion que @Autowired, pero en caso de varias DB nos permite decir,
                            cual es nuestra fuente de persistencia <persistence-unit>
                        */
     EntityManager em;

    @Transactional /** si queremos escribir en nuestra DB, necesitamos una transaccion */
    public Persona crearPersona(String nombre,String municipio){
        Persona p = new Persona();
        p.setNombre(nombre);
        p.setMunicipio(municipio);
        em.persist(p);
        return p;
    }

    public Persona obterMunicipioPersona(String nombre){
        return em.getReference(Persona.class,nombre);
    }
}
