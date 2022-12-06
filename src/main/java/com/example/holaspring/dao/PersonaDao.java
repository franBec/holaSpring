package com.example.holaspring.dao;

import com.example.holaspring.domain.Persona;
import org.springframework.data.repository.CrudRepository;

public interface PersonaDao extends CrudRepository<Persona, Long> {
}
