package com.example.holaspring.service;

import com.example.holaspring.dao.PersonaDao;
import com.example.holaspring.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService{

    @Autowired
    private PersonaDao personaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Persona> findAll() {
        return (List<Persona>) personaDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Persona findById(Long id) {
        return personaDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void save(Persona persona) {
        personaDao.save(persona);

    }

    @Override
    @Transactional
    public void delete(Persona persona) {
        personaDao.delete(persona);
    }
}
