package com.example.demo.adn.bbk.client.businesslayer.managerimpl;

import java.util.List;

import com.example.demo.adn.bbk.client.businesslayer.manager.ItemRepository;
import com.example.demo.adn.bbk.client.businesslayer.manager.ItemService;
import org.springframework.stereotype.Service;

import com.example.demo.adn.bbk.client.datalayer.modal.Item;
import com.example.demo.adn.bbk.client.datalayer.services.ItemRepository;
import com.example.demo.adn.bbk.client.datalayer.services.ItemService;

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
