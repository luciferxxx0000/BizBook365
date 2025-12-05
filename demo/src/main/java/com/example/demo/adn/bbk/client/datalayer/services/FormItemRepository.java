package com.example.demo.adn.bbk.client.datalayer.services;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.adn.bbk.client.datalayer.modal.FormItem;
import com.example.demo.adn.bbk.client.datalayer.modal.Item;

@Repository
public interface FormItemRepository extends JpaRepository<FormItem, Long> {

      @Query(
        value = "SELECT ft.item_id, it.item_name, it.item_description, it.status " +
                "FROM generativeforms gf " +
                "JOIN formitem ft ON gf.formseq = ft.form_id " +
                "JOIN item it ON it.item_id = ft.item_id " +
                "WHERE gf.formtemplate = :template",
        nativeQuery = true
    )
    List<Item> findItemsByFormTemplate(@Param("template") String template);

    
    @Query 
    List<FormItem> findByFormItemId(Long formItemId);

}
