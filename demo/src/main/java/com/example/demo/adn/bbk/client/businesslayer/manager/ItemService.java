package com.example.demo.adn.bbk.client.businesslayer.manager;

import java.util.List;


import com.example.demo.adn.bbk.client.datalayer.modal.Item;

public interface ItemService {
    Item saveItem(Item item);
    List<Item> getAllItems();
}

      

