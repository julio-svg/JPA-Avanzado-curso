package domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Persona {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nombre;

    /** Gracias al mappedBy
     *  1º no va a generar una tabla intermedia entre persona y coche tipo Persona_Coche con los id de persona y su rela
     *  ccion con coche_id
     *  2º nos ahorramos @JoinColumn, ya sabe que coche tiene un persona relaccionado y que va por la clave de persona
     */
    @OneToMany(mappedBy = "propietario")
    private List<Coche> listaCoches;

    public Persona addCoche(Coche coche){
        if(listaCoches == null){
            listaCoches = new ArrayList<>();
        }

        listaCoches.add(coche);

        return this;
    }
}
