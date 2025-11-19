package com.example.demo.adn.bbk.client.presentationlayer;



import org.springframework.stereotype.Controller;
// import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.adn.bbk.client.datalayer.modal.GenarativeForms;
import com.example.demo.adn.bbk.client.datalayer.services.GenerativeFormsService;
import com.example.demo.adn.bbk.client.datalayer.services.ItemService;
import com.example.demo.adn.bbk.client.datalayer.modal.Item;
import java.util.List;


import org.springframework.ui.Model;



                                           
@Controller
@RequestMapping("/generativeforms")
public class GenerativeFormsController {

    private final ItemService itemService;
    private final GenerativeFormsService generativeFormsService;

     public GenerativeFormsController(ItemService itemService, GenerativeFormsService generativeFormsService) {
        this.itemService = itemService;
        this.generativeFormsService = generativeFormsService;
    }

  @GetMapping("/showgere")
  public String showGenerativeReport( Model model) {

    List<Item> items = itemService.getAllItems();
    model.addAttribute("Generativeform", new GenarativeForms());
    model.addAttribute("items", items);
    return "GenerateForm/Formgenarate";
  }

  @PostMapping("/create")
  public String saveGenerativeForm(@ModelAttribute GenarativeForms genarativeForms, Model model,@RequestParam("GenerateitemId[]") List<Long> selectedItemIds,@RequestParam("Prices[]") List<Double> Prices) {
      generativeFormsService.saveForm(genarativeForms,selectedItemIds,Prices);
      return "redirect:/generativeforms/success/" + genarativeForms.getFormtemplate();
  }

  @GetMapping("/success/{formtemplate}")
  public String createformsuccess(@PathVariable String formtemplate, Model model) {
        model.addAttribute("link","http://localhost:8080/FormsSubmisson/show/" + formtemplate);
      return "GenerateForm/Form_Success";
  }
  



}
