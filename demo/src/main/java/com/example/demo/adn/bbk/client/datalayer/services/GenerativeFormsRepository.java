package com.example.demo.adn.bbk.client.datalayer.services;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.adn.bbk.client.datalayer.modal.GenarativeForms;
import com.example.demo.adn.bbk.client.datalayer.modal.Item;

public interface GenerativeFormsRepository extends JpaRepository<GenarativeForms, Long>{
    
    GenarativeForms findByFormseq(Long formseq);
    
    GenarativeForms findByFormtemplate(String formtemplate);


    
}
