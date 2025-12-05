package com.example.demo.adn.bbk.client.presentationlayer;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.adn.bbk.client.datalayer.modal.FormSubmisson;
import com.example.demo.adn.bbk.client.datalayer.services.FormSubmissonRepository;


@Controller
@RequestMapping("/ordermanagement")
public class OrderManagementController {

    private FormSubmissonRepository formSubmissonRepository;

    public OrderManagementController(FormSubmissonRepository formSubmissonRepository){
        this.formSubmissonRepository = formSubmissonRepository;
    }

    @GetMapping("/alloders")
    public String getOrders(Model model) {
        List<FormSubmisson> orders = formSubmissonRepository.findAll();
        model.addAttribute("orders", orders);
        return "BookingManagement/bookingmanagement";
    }

}
