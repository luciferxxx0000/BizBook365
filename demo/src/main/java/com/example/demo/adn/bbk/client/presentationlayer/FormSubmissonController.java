package com.example.demo.adn.bbk.client.presentationlayer;
import com.example.demo.adn.bbk.client.datalayer.services.GenerativeFormsRepository;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.adn.bbk.client.datalayer.services.FormItemRepository;
import com.example.demo.adn.bbk.client.datalayer.services.FormSubmissonService;


import org.springframework.ui.Model;


@Controller
@RequestMapping("/FormsSubmisson")
public class FormSubmissonController {

    private final FormItemRepository formItemRepository;


    private final FormSubmissonService formsubmissonService;

    public FormSubmissonController(FormSubmissonService formsubmissonService, FormItemRepository formItemRepository) {
        this.formsubmissonService = formsubmissonService;
        this.formItemRepository = formItemRepository;
    }

    @GetMapping("/show/{formtemplate}")
    public String ShowFormSubmission(@PathVariable String formtemplate,Model model) {
        model.addAttribute("items",formItemRepository.findItemsByFormTemplate(formtemplate));
        model.addAttribute("formtemplate", formtemplate);
        return "Formsubmission/CustomerForm"; 
        }

    @PostMapping("/submit/{formtemplate}")
    public String SubmitForm(@PathVariable String formtemplate,@RequestParam String customerName,
                             @RequestParam Integer MobileNo ,
                              @RequestParam String address,@RequestParam("itemId[]") List<Long> itemIds,
                              @RequestParam("quantity[]") List<Integer> quantities) {
        formsubmissonService.saveFormSubmission(formtemplate, customerName,MobileNo,address,itemIds,quantities);
        return "Formsubmission/FormSubmissionSuccess"; 
        }    

}