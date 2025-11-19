package com.example.demo.adn.bbk.client.datalayer.services;

import java.util.List;

import com.example.demo.adn.bbk.client.datalayer.modal.GenarativeForms;

public interface GenerativeFormsService {
    
    GenarativeForms saveForm(GenarativeForms genarativeForms, List<Long> selectedItemIds,List<Double> Prices);

}
