package domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Persona {

    @Id
    private String nombre;

    /*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return Objects.equals(nombre, persona.nombre);
    }*/
    /** modificacion sobre el equals y hasCode para que no de falsos positivos y falsos negativos con Hibernate (con otros
     proveedores no tiene por que pasar
     Se tiene que acceder a las variables de una entity atraves de sus getter
     Al hacer lazy loading con em.getReference no devuelve un tipo de la entidad(si no un subtipo) por eso cambiamos la
     comparacion o.getClas() por intanceof que si compara subclases
     */


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o instanceof Persona ) return false;
        Persona persona = (Persona) o;
        return Objects.equals(getNombre(), persona.getNombre());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNombre());
    }
}
