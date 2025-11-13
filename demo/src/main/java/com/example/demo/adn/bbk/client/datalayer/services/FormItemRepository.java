package com.example.demo.adn.bbk.client.datalayer.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.adn.bbk.client.datalayer.modal.FormItem;

@Repository
public interface FormItemRepository extends JpaRepository<FormItem, Long> {
    
}
