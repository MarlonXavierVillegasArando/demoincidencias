package com.abmodel.demoincidencias.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abmodel.demoincidencias.models.Section;

public interface SectionRepository extends JpaRepository<Section, Long> {
    
}
