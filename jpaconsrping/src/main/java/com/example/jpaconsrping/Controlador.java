package com.example.jpaconsrping;


import com.example.jpaconsrping.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Controlador {

    @Autowired
    Servicio servicio;

    @Value("${spring.jpa.open-in-view}")
    private String transactionScope;


    @RequestMapping(path = "/crearPersona")
    @ResponseBody
    public Persona crearPersona(String nombre,String municipio){
        return servicio.crearPersona(nombre,municipio);
    }


    @RequestMapping(path = "/obtenerMunicipio")
    @ResponseBody
    public String obterMunicipioPersona(String nombre){
        // al tener el persisten context en session view, no se ha cerrado con el @Transaction del servicio,
        // en logs se puede ver que lo recicla, y por ello no nos da error al ejecutar el lazyloading del getReference y
        // obtener el municipio
        log();
        return servicio.obterMunicipioPersona(nombre).getMunicipio();

    }

    private void log() {
        System.out.println("spring.jpa.open-in-view = " + transactionScope);
    }
}
