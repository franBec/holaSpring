package com.example.holaspring;

import com.example.holaspring.domain.Persona;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;

@Controller
@Slf4j
public class ControladorInicio {

    @Value("${index.saludo}")
    private String saludo;

    @GetMapping("/")
    public String inicio(Model model){
        var persona = new Persona();
        persona.setNombre("Juan");
        persona.setApellido("Perez");
        persona.setEmail("juan@gmail.com");
        persona.setTelefono("123");

        var persona2 = new Persona();
        persona2.setNombre("Carla");
        persona2.setApellido("Gomez");
        persona2.setEmail("carla@gmail.com");
        persona2.setTelefono("999");

        model.addAttribute("mensaje", "Mensaje con thymeleaf");
        model.addAttribute("saludo", saludo);
        model.addAttribute("personaList", Arrays.asList(persona, persona2));

        return "index";
    }
}
