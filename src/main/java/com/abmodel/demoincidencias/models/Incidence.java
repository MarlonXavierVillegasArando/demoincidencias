package com.abmodel.demoincidencias.models;

import com.abmodel.demoincidencias.enums.Impact;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "incidencia")
public class Incidence {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "seccion_id", nullable = false)
    private Section seccion;

    @ManyToOne
    @JoinColumn(name = "tipo_incidencia_id", nullable = false, referencedColumnName = "id")
    private TypeIncidence tipoIncidencia;

    // @Enumerated(EnumType.STRING)
    private Integer impacto;

    
    private Integer prioridad;

    @ManyToOne
    @JoinColumn(name = "responsable_persona_id", nullable = false, referencedColumnName = "id")
    private Person responsable;

    @ManyToOne
    @JoinColumn(name = "lider_persona_id", nullable = false, referencedColumnName = "id")
    private Person liderDesarrollo;


    public Incidence() {}

    public Incidence(

        String descripcion,
        Section seccion,
        TypeIncidence tipoIncidencia,
        Integer impacto,
        Integer prioridad,
        Person responsable,
        Person liderDesarrollo

    ) {

        this.descripcion = descripcion;
        this.seccion = seccion;
        this.tipoIncidencia = tipoIncidencia;
        this.impacto = impacto;
        this.prioridad = prioridad;
        this.responsable = responsable;
        this.liderDesarrollo = liderDesarrollo;
    }

    public Long getId(){ return id; }
    public void setId(Long id) { this.id = id;}

    public String getDescripcion(){ return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public Section getSeccion(){ return seccion; }
    public void setSeccion(Section seccion) { this.seccion = seccion; }
    public TypeIncidence getTipoIncidencia(){ return tipoIncidencia; }
    public void setTipoIncidencia(TypeIncidence tipoIncidencia) { this.tipoIncidencia = tipoIncidencia; }
    public int getImpacto(){ return impacto; }
    public void setImpacto(int impacto) { this.impacto = impacto; }
    public int getPrioridad(){ return prioridad; }
    public void setPrioridad(int prioridad) { this.prioridad = prioridad; }
    public Person getResponsable(){ return responsable; }
    public void setResponsable(Person responsable) { this.responsable = responsable; }
    public Person getLiderDesarrollo(){ return liderDesarrollo; }
    public void setLiderDesarrollo(Person liderDesarrollo) { this.liderDesarrollo = liderDesarrollo; }


}
