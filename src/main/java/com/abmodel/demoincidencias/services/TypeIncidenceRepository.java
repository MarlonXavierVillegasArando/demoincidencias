package com.abmodel.demoincidencias.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abmodel.demoincidencias.models.TypeIncidence;

public interface TypeIncidenceRepository  extends JpaRepository<TypeIncidence, Long> {
    
    

}
