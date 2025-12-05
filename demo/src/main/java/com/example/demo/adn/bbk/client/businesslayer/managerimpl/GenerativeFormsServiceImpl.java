package com.example.demo.adn.bbk.client.businesslayer.managerimpl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.demo.adn.bbk.client.businesslayer.manager.GenerativeFormsService;
import com.example.demo.adn.bbk.client.businesslayer.manager.ItemRepository;
import com.example.demo.adn.bbk.client.datalayer.modal.FormItem;
import com.example.demo.adn.bbk.client.datalayer.modal.GenarativeForms;
import com.example.demo.adn.bbk.client.datalayer.modal.Item;
import com.example.demo.adn.bbk.client.datalayer.services.FormItemRepository;
import com.example.demo.adn.bbk.client.datalayer.services.GenerativeFormsRepository;


@Service
public class GenerativeFormsServiceImpl implements GenerativeFormsService {

    private final FormItemRepository formItemRepository;
    private final ItemRepository itemRepository;
    private final GenerativeFormsRepository generativeFormsRepository;

    public GenerativeFormsServiceImpl(
            GenerativeFormsRepository generativeFormsRepository,
            ItemRepository itemRepository,
            FormItemRepository formItemRepository) {
        this.generativeFormsRepository = generativeFormsRepository;
        this.itemRepository = itemRepository;
        this.formItemRepository = formItemRepository;

    }

    @Override
    public GenarativeForms saveForm(GenarativeForms genarativeForms, List<Long> selectedItemIds, List<Double> prices) {

        // Generate form template
        genarativeForms.setFormtemplate(UUID.randomUUID().toString().substring(0, 10));

        // Save main form
        generativeFormsRepository.save(genarativeForms);
        System.out.println("✅ Generative form successfully saved");

        // Fetch selected items
        List<Item> selectedItems = itemRepository.findAllById(selectedItemIds);

        // Save each form-item relationship
        for (int i = 0; i < selectedItems.size(); i++) {
            Item item = selectedItems.get(i);
            Double itemPrice = prices.get(i);

            FormItem formItem = new FormItem();
            formItem.setForm(genarativeForms);
            formItem.setItem(item);
            formItem.setItemPrice(itemPrice);
            formItem.setStatus(1);

            formItemRepository.save(formItem);
        }

        System.out.println("✅ Form items successfully saved");

        return generativeFormsRepository.findById(genarativeForms.getFormseq()).orElse(null);
    }
}
