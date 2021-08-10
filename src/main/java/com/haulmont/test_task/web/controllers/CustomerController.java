package com.haulmont.test_task.web.controllers;

import com.haulmont.test_task.service.CustomerService;
import com.haulmont.test_task.service.dto.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Controller
public class CustomerController {

    private CustomerService service;

    @Autowired
    public void setService(CustomerService service) {
        this.service = service;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String customerMainPage(Model model){
        List<CustomerDTO> customers = service.findAll();
        model.addAttribute("customer_list", customers);
        model.addAttribute("new_customer", new CustomerDTO());
        return "customer_page";
    }

    @RequestMapping(value = "/add/", method = RequestMethod.POST)
    public String customerAdd(@Valid @ModelAttribute("new_customer") CustomerDTO newCustomer,
                              BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            List<CustomerDTO> customerList = service.findAll();
            model.addAttribute("customer_list", customerList);
            return "customer_page";
        }
        service.save(newCustomer);
        return "redirect:/";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String customerDelete(@PathVariable("id") UUID cusstomerId){
        if(service.checkCustomerOnCredit(cusstomerId)){
            return "redirect:/bank/";
        }
        service.delete(cusstomerId);
        return "redirect:/";
    }
}
