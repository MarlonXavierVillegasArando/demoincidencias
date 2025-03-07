package com.abmodel.demoincidencias.models;

import jakarta.validation.constraints.NotEmpty;

public class IncidenceDto {
    
    @NotEmpty(message = "El campo no puede estar vacio")
    private Long id = Long.valueOf(0);
    @NotEmpty(message = "El campo no puede estar vacio")
    private String descripcion;
    @NotEmpty(message = "El campo no puede estar vacio")
    private Long seccion_id;
    @NotEmpty(message = "El campo no puede estar vacio")
    private Long tipo_incidencia_id;
    @NotEmpty(message = "El campo no puede estar vacio")
    private Integer impacto;
    @NotEmpty(message = "El campo no puede estar vacio")
    private Integer prioridad;
    @NotEmpty(message = "El campo no puede estar vacio")
    private Long responsable_persona_id;
    @NotEmpty(message = "El campo no puede estar vacio")
    private Long lider_persona_id;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Long getSeccion_id() {
        return seccion_id;
    }
    public void setSeccion_id(Long seccion_id) {
        this.seccion_id = seccion_id;
    }
    public Long getTipo_incidencia_id() {
        return tipo_incidencia_id;
    }
    public void setTipo_incidencia_id(Long tipo_incidencia_id) {
        this.tipo_incidencia_id = tipo_incidencia_id;
    }
    public Integer getImpacto() {
        return impacto;
    }
    public void setImpacto(Integer impacto) {
        this.impacto = impacto;
    }
    public Integer getPrioridad() {
        return prioridad;
    }
    public void setPrioridad(Integer prioridad) {
        this.prioridad = prioridad;
    }
    public Long getResponsable_persona_id() {
        return responsable_persona_id;
    }
    public void setResponsable_persona_id(Long responsable_persona_id) {
        this.responsable_persona_id = responsable_persona_id;
    }
    public Long getLider_persona_id() {
        return lider_persona_id;
    }
    public void setLider_persona_id(Long lider_persona_id) {
        this.lider_persona_id = lider_persona_id;
    }



    

}
