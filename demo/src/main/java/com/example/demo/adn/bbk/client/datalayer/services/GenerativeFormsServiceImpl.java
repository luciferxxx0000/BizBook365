package com.example.demo.adn.bbk.client.datalayer.services;


import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.adn.bbk.client.datalayer.modal.GenarativeForms;

@Service
public class GenerativeFormsServiceImpl implements GenerativeFormsService {

    

    @Autowired
    private final GenerativeFormsRepository generativeFormsRepository;


    GenerativeFormsServiceImpl(GenerativeFormsRepository generativeFormsRepository) {
        this.generativeFormsRepository = generativeFormsRepository;
    }

    @Override
    public GenarativeForms saveForm(GenarativeForms genarativeForms) {
        genarativeForms.setFormtemplate(UUID.randomUUID().toString().substring(0,10));
        return generativeFormsRepository.save(genarativeForms);
    }
}
