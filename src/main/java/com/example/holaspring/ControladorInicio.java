package com.example.holaspring;

import com.example.holaspring.domain.Persona;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

        model.addAttribute("mensaje", "Mensaje con thymeleaf");
        model.addAttribute("saludo", saludo);
        model.addAttribute("persona", persona);

        return "index";
    }
}
