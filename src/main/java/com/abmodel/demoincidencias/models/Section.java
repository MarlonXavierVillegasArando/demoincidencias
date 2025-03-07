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
@Table(name = "seccion")
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;

    // @OneToMany(mappedBy = "seccion", cascade = CascadeType.ALL, orphanRemoval = true)
    // private List<Incidence> incidencias;

    public Section() {}

    public Section(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id;    }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    // public List<Incidence> getIncidencias() { return incidencias; }
    // public void setIncidencias(List<Incidence> incidencias) { this.incidencias = incidencias; }
}
