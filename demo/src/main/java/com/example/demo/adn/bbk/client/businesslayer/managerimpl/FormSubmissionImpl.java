package com.example.demo.adn.bbk.client.businesslayer.managerimpl;
import com.example.demo.adn.bbk.client.datalayer.services.GenerativeFormsRepository;
import com.example.demo.adn.bbk.client.datalayer.services.ItemRepository;

import java.util.List;


import org.springframework.stereotype.Service;

import com.example.demo.adn.bbk.client.datalayer.modal.FormSubmissionItem;
import com.example.demo.adn.bbk.client.datalayer.modal.FormSubmisson;
import com.example.demo.adn.bbk.client.datalayer.modal.Item;
import com.example.demo.adn.bbk.client.datalayer.services.FormItemRepository;
import com.example.demo.adn.bbk.client.datalayer.services.FormSubmissionItemRepository;
import com.example.demo.adn.bbk.client.datalayer.services.FormSubmissonRepository;
import com.example.demo.adn.bbk.client.datalayer.services.FormSubmissonService;

@Service
public class FormSubmissionImpl implements FormSubmissonService {


    private final GenerativeFormsRepository generativeFormsRepository;
    private final FormSubmissonRepository formSubmissonRepository;
    private final FormSubmissionItemRepository formSubmissionItemRepository;
    private final ItemRepository itemRepository;

     public FormSubmissionImpl(GenerativeFormsRepository generativeFormsRepository,
                                 FormSubmissonRepository formSubmissonRepository,
                                 FormSubmissionItemRepository formSubmissionItemRepository,
                                  FormItemRepository formItemRepository,ItemRepository itemRepository) {
        this.generativeFormsRepository = generativeFormsRepository;
        this.formSubmissonRepository = formSubmissonRepository;
        this.formSubmissionItemRepository = formSubmissionItemRepository;
        this.itemRepository = itemRepository;
    }
   
    
    @Override
    public FormSubmisson saveFormSubmission( String formtemplate, String customerName, Integer MobileNo,String address,List<Long> ItemIds,List<Integer> quentities) {

        FormSubmisson formSubmisson = new FormSubmisson();
        
        formSubmisson.setCustomerName(customerName);
        formSubmisson.setMobileNumber(MobileNo);
        formSubmisson . setAddress(address);
        formSubmisson.setGenarativeForms(generativeFormsRepository.findByFormtemplate(formtemplate));
        System.out.println("Form Template: " + generativeFormsRepository.findByFormtemplate(formtemplate));
        formSubmisson.setStatus(1);
        
        formSubmissonRepository.save(formSubmisson);


        
        List<Item> selectedItems = itemRepository.findAllById(ItemIds);
        for (int i = 0; i < ItemIds.size(); i++) {

            Item item = selectedItems.get(i);
            Integer quantity = quentities.get(i);

            FormSubmissionItem submissionItem = new FormSubmissionItem();

            submissionItem.setItem(item);
            submissionItem.setQuantity(quantity);
            submissionItem.setFormSubmisson(formSubmisson);
            formSubmissionItemRepository.save(submissionItem);
        }

        return formSubmisson;
    }
}

