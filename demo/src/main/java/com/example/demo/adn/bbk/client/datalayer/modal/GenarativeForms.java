package com.example.demo.adn.bbk.client.datalayer.modal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "generativeforms")
public class GenarativeForms {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long formseq;

    private String formname;

    private String formdescription;

    private String formtemplate;

    @Column(name = "form_Seq", nullable = false)
    public Long getFormseq() {
        return formseq;
    }

    public void setFormseq(Long formseq) {
        this.formseq = formseq;
    }

    @Column(name = "form_name", nullable = false)
    public String getFormname() {
        return formname;
    }

    public void setFormname(String formname) {
        this.formname = formname;
    }

    @Column(name = "form_description", nullable = false)
    public String getFormdescription() {
        return formdescription;
    }

    public void setFormdescription(String formdescription) {
        this.formdescription = formdescription;
    }
    @Column(name = "form_template", nullable = false)
    public String getFormtemplate() {
        return formtemplate;
    }
    public void setFormtemplate(String formtemplate) {
        this.formtemplate = formtemplate;
    }
}