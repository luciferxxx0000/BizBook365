package com.example.demo.adn.bbk.client.businesslayer.managerimpl;
import com.example.demo.adn.bbk.client.datalayer.services.GenerativeFormsRepository;
import org.springframework.stereotype.Service;

import com.example.demo.adn.bbk.client.datalayer.modal.FormSubmisson;
import com.example.demo.adn.bbk.client.datalayer.services.FormSubmissonRepository;
import com.example.demo.adn.bbk.client.datalayer.services.FormSubmissonService;

@Service
public class FormSubmissionImpl implements FormSubmissonService {

    private final GenerativeFormsRepository generativeFormsRepository;
    private final FormSubmissonRepository formSubmissonRepository;

     public FormSubmissionImpl(GenerativeFormsRepository generativeFormsRepository, FormSubmissonRepository formSubmissonRepository) {
        this.generativeFormsRepository = generativeFormsRepository;
        this.formSubmissonRepository = formSubmissonRepository;
    }
   
    
    @Override
    public FormSubmisson saveFormSubmission( String formtemplate, String customerName, Integer MobileNo) {
        FormSubmisson formSubmisson = new FormSubmisson();

        formSubmisson.setCustomerName(customerName);
        formSubmisson.setMobileNumber(MobileNo);
        formSubmisson.setGenarativeForms(generativeFormsRepository.findByFormtemplate(formtemplate));
        System.out.println("Form Template: " + generativeFormsRepository.findByFormtemplate(formtemplate));
        formSubmisson.setStatus(1);
        formSubmissonRepository.save(formSubmisson);

        return formSubmisson;
    }
}
