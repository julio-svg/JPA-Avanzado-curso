package com.example.jpaconsrping.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Persona {

    @Id
    private String nombre;

    private String municipio;
}
