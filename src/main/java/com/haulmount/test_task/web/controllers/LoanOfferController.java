package com.haulmount.test_task.web.controllers;

import com.haulmount.test_task.dao.entity.YearsOfCredit;
import com.haulmount.test_task.service.CreditService;
import com.haulmount.test_task.service.CustomerService;
import com.haulmount.test_task.service.dto.CreditDTO;
import com.haulmount.test_task.service.dto.CustomerDTO;
import com.haulmount.test_task.service.dto.LoanOfferDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/loan_offer")
public class LoanOfferController {

    private CustomerService customerService;
    private CreditService creditService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Autowired
    public void setCreditService(CreditService creditService) {
        this.creditService = creditService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String loanOfferMainPage(Model model){
        List<CustomerDTO> customers = customerService.findAll();
        List<CreditDTO> credits = creditService.findAll();
        LoanOfferDTO newLoanOffer = new LoanOfferDTO();
        YearsOfCredit[] yearsOfCredit = YearsOfCredit.values();
        model.addAttribute("customers", customers);
        model.addAttribute("credits", credits);
        model.addAttribute("new_loan_offer", newLoanOffer);
        model.addAttribute("years_of_credit", yearsOfCredit);
        return "loan_offer_page";
    }

    @RequestMapping(value = "/add/", method = RequestMethod.POST)
    public String calculateNewLoanOffer(@ModelAttribute("new_loan_offer") LoanOfferDTO newLoanOffer, Model model){
        return "redirect:/loan_offer/";
    }
}
