package com.haulmont.test_task.web.controllers;

import com.haulmont.test_task.service.CreditService;
import com.haulmont.test_task.service.dto.BankDTO;
import com.haulmont.test_task.service.dto.CreditDTO;
import com.haulmont.test_task.service.BankService;
import com.haulmont.test_task.service.CustomerService;
import com.haulmont.test_task.service.LoanOfferService;
import com.haulmont.test_task.service.dto.CustomerDTO;
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
@RequestMapping("/bank")
public class BankController {

    private BankService bankService;
    private CustomerService customerService;
    private CreditService creditService;
    private LoanOfferService loanOfferService;

    @Autowired
    public void setService(BankService service) {
        this.bankService = service;
    }

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Autowired
    public void setCreditService(CreditService creditService) {
        this.creditService = creditService;
    }

    @Autowired
    public void setLoanOfferService(LoanOfferService loanOfferService) {
        this.loanOfferService = loanOfferService;
    }

    @Autowired
    public void setBankService(BankService bankService) {
        this.bankService = bankService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String bankMainPage(Model model){
        List<BankDTO> banks = bankService.findAll();
        List<CustomerDTO> customers = customerService.findAll();
        List<CreditDTO> credits = creditService.findAll();
        BankDTO newBank = new BankDTO();
        model.addAttribute("bank_list", banks);
        model.addAttribute("customer_list", customers);
        model.addAttribute("credit_list", credits);
        model.addAttribute("new_bank", newBank);
        return "bank_page";
    }

    @RequestMapping(value = "/add/", method = RequestMethod.POST)
    public String bankAdd(@Valid @ModelAttribute("new_bank") BankDTO newBank,
                          BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            List<BankDTO> banks = bankService.findAll();
            List<CustomerDTO> customers = customerService.findAll();
            List<CreditDTO> credits = creditService.findAll();
            model.addAttribute("bank_list", banks);
            model.addAttribute("customer_list", customers);
            model.addAttribute("credit_list", credits);
            return "bank_page";
        }
        bankService.save(newBank);
        return "redirect:/bank/";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String bankDelete(@PathVariable("id") UUID bankId){
        loanOfferService.deleteCreditRecord(bankId);
        bankService.delete(bankId);
        return "redirect:/bank/";
    }
}
