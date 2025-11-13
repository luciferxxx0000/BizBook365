package com.example.demo.adn.bbk.client.datalayer.services;

import com.example.demo.adn.bbk.client.datalayer.modal.FormSubmisson;

public interface FormSubmissonService {
    
    FormSubmisson saveFormSubmission( String formtemplate, String customerName, Integer mobileNumber);
    
}
