package com.example.holaspring.controller;

import com.example.holaspring.domain.Persona;
import com.example.holaspring.service.PersonaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ControladorInicio {

    @Autowired
    private PersonaService personaService;

    @GetMapping("/")
    public String inicio(Model model){
        model.addAttribute("personaList", personaService.findAll());
        return "index";
    }

    @GetMapping("/create")
    public String create(Persona persona){
        return "createOrEdit";
    }

    @PostMapping("/save")
    public String save(Persona persona){
        personaService.save(persona);
        return "redirect:/";
    }

    @GetMapping("/edit/{idPersona}")
    public String edit(Persona persona, Model model){
        persona = personaService.findById(persona.getIdPersona());
        model.addAttribute("persona", persona);
        return "createOrEdit";
    }

    @GetMapping("/delete/{idPersona}")
    public String delete(Persona persona){
        personaService.delete(persona);
        return "redirect:/";
    }
}
