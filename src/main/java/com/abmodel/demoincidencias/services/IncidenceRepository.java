package com.abmodel.demoincidencias.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abmodel.demoincidencias.models.Incidence;

public interface IncidenceRepository  extends JpaRepository<Incidence, Long> {
    
}
