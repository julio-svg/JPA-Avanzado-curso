package domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Coche {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String modelo;
    @ManyToOne
    private Persona propietario;
}
