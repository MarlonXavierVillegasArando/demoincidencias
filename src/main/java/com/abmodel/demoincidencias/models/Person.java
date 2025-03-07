package com.abmodel.demoincidencias.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "persona")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreCompleto;

    // @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true)
    // private List<Incidence> incidencias;

    public Person() {}
    public Person(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id;    }

    public String getNombreCompleto() { return nombreCompleto; }
    public void setNombreCompleto(String nombreCompleto) { this.nombreCompleto = nombreCompleto; }

    // public List<Incidence> getIncidencias() { return incidencias; }
    // public void setIncidencias(List<Incidence> incidencias) { this.incidencias = incidencias; }
}
