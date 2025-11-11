package com.example.demo.adn.bbk.client.presentationlayer;

import org.springframework.stereotype.Controller;

import com.example.demo.adn.bbk.client.datalayer.modal.Item;
import com.example.demo.adn.bbk.client.datalayer.services.ItemService;


import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/items/new")
    public String showItemForm(Model model) {
        model.addAttribute("item", new Item());
        return "Item/ItemCreation";
    }

    @PostMapping("/items/save")
    public String saveItem(@ModelAttribute("item") Item item) {
        itemService.saveItem(item);
        return "redirect:/items/new";
    }
    
    
}
