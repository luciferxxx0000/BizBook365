package com.example.demo.adn.bbk.client.businesslayer.managerimpl;


import java.util.UUID;

import com.example.demo.adn.bbk.client.datalayer.services.GenerativeFormsRepository;
import com.example.demo.adn.bbk.client.businesslayer.manager.GenerativeFormsService;
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
