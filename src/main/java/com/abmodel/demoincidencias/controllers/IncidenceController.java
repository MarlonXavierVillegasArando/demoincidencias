package com.abmodel.demoincidencias.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.abmodel.demoincidencias.models.TypeIncidence;
import com.abmodel.demoincidencias.services.TypeIncidenceRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/incidence")
public class IncidenceController {
    @Autowired
    private TypeIncidenceRepository typeIncidenceRepository;

    @GetMapping({"", "/"})
    public String showTypesIncidence (Model model){
        List<TypeIncidence> typesIncidence = typeIncidenceRepository.findAll();
        model.addAttribute("typesIncidence", typesIncidence);
        return "incidencia/index";
    }
}
