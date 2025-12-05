package com.example.demo.adn.bbk.client.datalayer.services;

import java.util.List;

import com.example.demo.adn.bbk.client.datalayer.modal.FormSubmisson;

public interface FormSubmissonService {
    
    FormSubmisson saveFormSubmission( String formtemplate, String customerName, Integer mobileNumber,String address,List<Long> itemIds,List<Integer> quantities);

  
}
