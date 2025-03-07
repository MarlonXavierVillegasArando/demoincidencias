package com.abmodel.demoincidencias.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.abmodel.demoincidencias.models.Incidence;
import com.abmodel.demoincidencias.models.IncidenceDto;
import com.abmodel.demoincidencias.models.Person;
import com.abmodel.demoincidencias.models.Section;
import com.abmodel.demoincidencias.models.TypeIncidence;
import com.abmodel.demoincidencias.services.IncidenceRepository;
import com.abmodel.demoincidencias.services.PersonRepository;
import com.abmodel.demoincidencias.services.SectionRepository;
import com.abmodel.demoincidencias.services.TypeIncidenceRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@RequestMapping("/incidence")
public class IncidenceController {
    @Autowired
    private IncidenceRepository incidenceRepository;
    @Autowired
    private TypeIncidenceRepository typeIncidenceRepository;
    @Autowired
    private SectionRepository sectionRepository;
    @Autowired
    private PersonRepository personRepository;
    


    @GetMapping({"", "/"})
    public String showTypesIncidence (Model model){

        Map<Integer, String> listImpacto = new HashMap<Integer, String>();
        listImpacto.put(1, "BAJA");
        listImpacto.put(2, "NORMAL");
        listImpacto.put(3, "ALTA");

        
        Map<Integer, String> listPrioridad = new HashMap<Integer, String>();
        listPrioridad.put(1, "NO URGENTE");
        listPrioridad.put(2, "NORMAL");
        listPrioridad.put(3, "URGENTE");

        List<Incidence> incidences = incidenceRepository.findAll();
        model.addAttribute("listPrioridad", listPrioridad);
        model.addAttribute("listImpacto", listImpacto);
        model.addAttribute("incidences", incidences);
        return "incidencia/index";
    }


    @GetMapping("/create")
    public String createIncidence(Model model){

        //person list
        List<Person> persons = personRepository.findAll();
        //section list
        List<Section> sections = sectionRepository.findAll();
        //type incidence list
        List<TypeIncidence> typeIncidences = typeIncidenceRepository.findAll();
        
        Map<Integer, String> listImpacto = new HashMap<Integer, String>();
        listImpacto.put(1, "BAJA");
        listImpacto.put(2, "NORMAL");
        listImpacto.put(3, "ALTA");

        Map<Integer, String> listPrioridad = new HashMap<Integer, String>();
        listPrioridad.put(1, "NO URGENTE");
        listPrioridad.put(2, "NORMAL");
        listPrioridad.put(3, "URGENTE");

        IncidenceDto incidenceDto = new IncidenceDto();

        model.addAttribute("incidenceDto", incidenceDto);
        model.addAttribute("persons", persons);
        model.addAttribute("sections", sections);
        model.addAttribute("typeIncidences", typeIncidences);
        model.addAttribute("listPrioridad", listPrioridad);
        model.addAttribute("listImpacto", listImpacto);
        return "incidencia/create";
    }


    @PostMapping("/store")
    public String storeIncidence(@ModelAttribute IncidenceDto incidenceDto, BindingResult result) {
        // if(result.hasErrors()){
        //     return "incidencia/create";
        // }
        try {
            Incidence incidence = new Incidence();
            incidence.setDescripcion(incidenceDto.getDescripcion());
            incidence.setImpacto(incidenceDto.getImpacto());
            incidence.setPrioridad(incidenceDto.getPrioridad());
            incidence.setSeccion(sectionRepository.findById(incidenceDto.getSeccion_id()).get());
            incidence.setTipoIncidencia(typeIncidenceRepository.findById(incidenceDto.getTipo_incidencia_id()).get());
            incidence.setResponsable(personRepository.findById(incidenceDto.getResponsable_persona_id()).get());
            incidence.setLiderDesarrollo(personRepository.findById(incidenceDto.getLider_persona_id()).get());
            incidenceRepository.save(incidence);
        } catch (Exception e) {
            System.out.println(e);
        }
        
        

        return "redirect:/incidence";
    }
    
    @GetMapping("/edit")
    public String showEditPage(Model model, @RequestParam Long id){
        try {
            Incidence incidence = incidenceRepository.findById(id).get();
            model.addAttribute("incidence", incidence);

            IncidenceDto incidenceDto = new IncidenceDto();
            incidenceDto.setId(incidence.getId());
            incidenceDto.setDescripcion(incidence.getDescripcion());
            incidenceDto.setImpacto(incidence.getImpacto());
            incidenceDto.setPrioridad(incidence.getPrioridad());
            incidenceDto.setSeccion_id(incidence.getSeccion().getId());
            incidenceDto.setTipo_incidencia_id(incidence.getTipoIncidencia().getId());
            
            model.addAttribute("incidenceDto", incidenceDto);


        } catch (Exception e) {
            System.out.println("Excepcion:"+e.getMessage());
            return "redirect:/incidence";
        }

        return "incidence/edit";
    }

}
