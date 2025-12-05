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
@Table(name = "formsubmissionitem")
public class FormSubmissionItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long FormSubmissionItemId;

    @ManyToOne
    @JoinColumn(name = "formsubmission_id")
    private FormSubmisson formSubmisson;


    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    private Integer quantity;

    private Double amount;

    @Column(name = "form_submission_item_id")
    public Long getFormSubmissionItemId() {
        return FormSubmissionItemId;
    }

    public void setFormSubmissionItemId(Long formSubmissionItemId) {
        FormSubmissionItemId = formSubmissionItemId;
    }

    
    public FormSubmisson getFormSubmisson() {
        return formSubmisson;
    }
    public void setFormSubmisson(FormSubmisson formSubmisson) {
        this.formSubmisson = formSubmisson;
    }

    
    public Item getItem() {
        return item;
    }
    public void setItem(Item item) {
        this.item = item;
    }


    @Column(name = "quantity")
    public Integer getQuantity(){
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


    @Column(name = "amount")
    public Double getAmount(){
        return amount;
    }
    public void setAmount(Double amount) {
        this.amount = amount;
    }


}
