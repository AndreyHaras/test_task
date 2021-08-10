package com.haulmont.test_task.web.controllers;

import com.haulmont.test_task.service.CreditService;
import com.haulmont.test_task.service.dto.CreditDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/credit")
public class CreditController {

    private CreditService service;

    @Autowired
    public void setService(CreditService service) {
        this.service = service;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String creditMainPage(Model model){
        List<CreditDTO> credits = service.findAll();
        CreditDTO newCredit = new CreditDTO();
        model.addAttribute("credit_list", credits);
        model.addAttribute("new_credit", newCredit);
        return "credit_page";
    }

    @RequestMapping(value = "/add/", method = RequestMethod.POST)
    public String creditAdd(@Valid @ModelAttribute("new_credit") CreditDTO newCredit,
                            BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            List<CreditDTO> credits = service.findAll();
            model.addAttribute("credit_list", credits);
            return "credit_page";
        }
        service.save(newCredit);
        return "redirect:/credit/";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteCredit(@PathVariable("id") UUID creditId){
        if(service.checkCredit(creditId)){
            return "redirect:/bank/";
        }
        service.delete(creditId);
        return "redirect:/credit/";
    }
}
