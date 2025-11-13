package com.example.demo.adn.bbk.client.datalayer.modal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "formitem")
public class FormItem {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long formItemId;

    @ManyToOne
    @JoinColumn(name = "form_id", nullable = false)
    private GenarativeForms form;

    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;

    private Integer status;

    private Double itemPrice;

    // Getters and Setters
    @Column(name = "form_item_id")
    public Long getFormItemId() {
        return formItemId;
    }

    public void setFormItemId(Long formItemId) {
        this.formItemId = formItemId;
    }

    @Column(name = "form_id")
    public GenarativeForms getForm() {
        return form;
    }

    public void setForm(GenarativeForms form) {
        this.form = form;
    }

    @Column(name = "item_id")
    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Column(name = "item_price")
    public Double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }
}
