package com.example.demo.adn.bbk.client.presentationlayer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.adn.bbk.client.datalayer.services.FormSubmissonService;


import org.springframework.ui.Model;


@Controller
@RequestMapping("/FormsSubmisson")
public class FormSubmissonController {

    private final FormSubmissonService formsubmissonService;

    public FormSubmissonController(FormSubmissonService formsubmissonService) {
        this.formsubmissonService = formsubmissonService;
    }

    @GetMapping("/show/{formtemplate}")
    public String ShowFormSubmission(@PathVariable String formtemplate,Model model) {
        model.addAttribute("formtemplate", formtemplate);
        return "Formsubmission/CustomerForm"; 
        }

    @PostMapping("/submit/{formtemplate}")
    public String SubmitForm(@PathVariable String formtemplate,@RequestParam String customerName,
                             @RequestParam Integer MobileNo) {
        System.out.println("customerName: " + customerName);
        System.out.println("MobileNo: " + MobileNo);
        formsubmissonService.saveFormSubmission(formtemplate, customerName, MobileNo);
        return "Formsubmission/SubmissionSuccess"; 
        }    

}