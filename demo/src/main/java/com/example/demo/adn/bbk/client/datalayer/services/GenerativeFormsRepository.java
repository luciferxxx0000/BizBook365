package com.example.demo.adn.bbk.client.datalayer.services;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.adn.bbk.client.datalayer.modal.GenarativeForms;

public interface GenerativeFormsRepository extends JpaRepository<GenarativeForms, Long>{
    
    GenarativeForms findByFormseq(Long formseq);
    
}
