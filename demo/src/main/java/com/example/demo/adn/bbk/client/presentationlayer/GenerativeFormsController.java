package com.example.demo.adn.bbk.client.presentationlayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
// import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.adn.bbk.client.datalayer.modal.GenarativeForms;
import com.example.demo.adn.bbk.client.datalayer.services.GenerativeFormsService;

import org.springframework.ui.Model;



                                           
@Controller
@RequestMapping("/generativeforms")
public class GenerativeFormsController {

    @Autowired
    private GenerativeFormsService generativeFormsService;

  @GetMapping("/showgere")
  public String showGenerativeReport( Model model) {
    model.addAttribute("Generativeform", new GenarativeForms());
    return "GenerateForm/Formgenarate";
  }

  @PostMapping("/create")
  public String saveGenerativeForm(@ModelAttribute GenarativeForms genarativeForms, Model model) {
      generativeFormsService.saveForm(genarativeForms);
      return "redirect:/generativeforms/success/" + genarativeForms.getFormtemplate();
  }

  @GetMapping("/success/{formtemplate}")
  public String createformsuccess(@PathVariable String formtemplate, Model model) {
        model.addAttribute("link","http://localhost:8080/forms/" + formtemplate);
      return "GenerateForm/Form_Success";
  }
  



}
