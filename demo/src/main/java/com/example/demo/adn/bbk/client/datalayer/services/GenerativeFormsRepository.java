package com.example.demo.adn.bbk.client.datalayer.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.adn.bbk.client.datalayer.modal.GenarativeForms;

public interface GenerativeFormsRepository extends JpaRepository<GenarativeForms, Long>{
    
    GenarativeForms findByFormseq(Long formseq);
    
    // @Query("SELECT formseq FROM GenarativeForms g WHERE g.formtemplate = ?1")
    // GenarativeForms findByFormtemplate(String formtemplate);

    GenarativeForms findByFormtemplate(String formtemplate);
    
}
