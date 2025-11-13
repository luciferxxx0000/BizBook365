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
@Table(name = "formsubmission")
public class FormSubmisson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "form_submission_id")
    private Long formSubmissionId;

   
    private String customerName;

    
    private Integer mobileNumber;

    @ManyToOne
    @JoinColumn(name = "form_id", nullable = false)
    private GenarativeForms genarativeForms;

    private Integer status;


    // Getters and Setters
    public Long getFormSubmissionId() {
        return formSubmissionId;
    }

    public void setFormSubmissionId(Long formSubmissionId) {
        this.formSubmissionId = formSubmissionId;
    }

    @Column(name = "customer_name", nullable = false)
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Column(name = "mobile_number")
    public Integer getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(Integer mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public GenarativeForms getGenarativeForms() {
        return genarativeForms;
    }

    public void setGenarativeForms(GenarativeForms genarativeForms) {
        this.genarativeForms = genarativeForms;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
