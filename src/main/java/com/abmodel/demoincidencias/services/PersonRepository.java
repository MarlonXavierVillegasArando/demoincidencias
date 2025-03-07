package com.abmodel.demoincidencias.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abmodel.demoincidencias.models.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
    
}
