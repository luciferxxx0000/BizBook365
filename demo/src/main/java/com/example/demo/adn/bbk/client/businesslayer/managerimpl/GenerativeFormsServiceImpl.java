package com.example.demo.adn.bbk.client.businesslayer.managerimpl;


import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.adn.bbk.client.datalayer.modal.FormItem;
import com.example.demo.adn.bbk.client.datalayer.modal.GenarativeForms;
import com.example.demo.adn.bbk.client.datalayer.modal.Item;
import com.example.demo.adn.bbk.client.datalayer.services.FormItemRepository;
import com.example.demo.adn.bbk.client.datalayer.services.GenerativeFormsRepository;
import com.example.demo.adn.bbk.client.datalayer.services.GenerativeFormsService;
import com.example.demo.adn.bbk.client.datalayer.services.ItemRepository;

@Service
public class GenerativeFormsServiceImpl implements GenerativeFormsService {

    private final FormItemRepository formItemRepository;

    private final ItemRepository itemRepository;

    

    @Autowired
    private final GenerativeFormsRepository generativeFormsRepository;


    GenerativeFormsServiceImpl(GenerativeFormsRepository generativeFormsRepository,ItemRepository itemRepository, FormItemRepository formItemRepository) {
        this.generativeFormsRepository = generativeFormsRepository;
        this.itemRepository = itemRepository;
        this.formItemRepository = formItemRepository;
    }

    @Override
    public GenarativeForms saveForm(GenarativeForms genarativeForms, List<Long> selectedItemIds ) {

        genarativeForms.setFormtemplate(UUID.randomUUID().toString().substring(0,10));
        generativeFormsRepository.save(genarativeForms);
        System.out.println("\u2705 Generativeform successfully saved");

        List<Item> selectedItems = itemRepository.findAllById(selectedItemIds);
        for (Item item : selectedItems) {
            FormItem formItem = new FormItem();
            formItem.setForm(genarativeForms);
            formItem.setItem(item);
            formItem.setStatus(1); // Set the status as needed
            formItemRepository.save(formItem);
        }
            System.out.println("\u2705Form items successfully saved");
            return generativeFormsRepository.findById(genarativeForms.getFormseq()).orElse(null);
        
    }
}
