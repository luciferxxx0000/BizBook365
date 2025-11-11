package com.example.demo.adn.bbk.client.datalayer.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.adn.bbk.client.datalayer.modal.Item;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item saveItem(Item item) {
        item.setStatus(1);
        return itemRepository.save(item);
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }
    
}
