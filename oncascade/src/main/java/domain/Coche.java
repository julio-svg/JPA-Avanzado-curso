package domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Coche {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String modelo;
    /** sin esto cascade = CascadeType.PERSIST la main da error pues persona no se persiste y es necesario
     * Caused by: org.hibernate.TransientPropertyValueException: object references an unsaved transient instance -
     * save the transient instance before flushing : domain.Coche.propietario -> domain.Persona
     */
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Persona propietario;

}
