package com.example.holaspring.controller;

import com.example.holaspring.domain.Persona;
import com.example.holaspring.service.PersonaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@Slf4j
public class ControladorInicio {

    @Autowired
    private PersonaService personaService;

    @GetMapping("/")
    public String inicio(Model model, @AuthenticationPrincipal User user){
        log.info("Usuario logueado: "+user);

        List<Persona> personaList = personaService.findAll();
        double saldoTotal = 0;
        for(Persona persona : personaList){
            saldoTotal += persona.getSaldo();
        }

        model.addAttribute("personaList", personaList);
        model.addAttribute("saldoTotal", saldoTotal);
        model.addAttribute("totalClientes", personaList.size());
        return "index";
    }

    @GetMapping("/create")
    public String create(Persona persona){
        return "createOrEdit";
    }

    @PostMapping("/save")
    public String save(@Valid Persona persona, Errors errors){
        if(errors.hasErrors()){
            return "createOrEdit";
        }
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
