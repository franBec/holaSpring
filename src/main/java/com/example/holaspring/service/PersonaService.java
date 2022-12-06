package com.example.holaspring.service;

import com.example.holaspring.domain.Persona;

import java.util.List;

public interface PersonaService {
    List<Persona> findAll();

    Persona findById(Long id);

    void save(Persona persona);

    void delete(Persona persona);
}
