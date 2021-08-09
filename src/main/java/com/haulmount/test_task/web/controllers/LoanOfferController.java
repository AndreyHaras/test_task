package com.haulmount.test_task.web.controllers;

import com.haulmount.test_task.dao.entity.YearsOfCredit;
import com.haulmount.test_task.service.CreditService;
import com.haulmount.test_task.service.CustomerService;
import com.haulmount.test_task.service.LoanOfferService;
import com.haulmount.test_task.service.PaymentScheduleService;
import com.haulmount.test_task.service.dto.*;
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
    private LoanOfferService loanOfferService;
    private PaymentScheduleService paymentScheduleService;

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
    public void setPaymentScheduleService(PaymentScheduleService paymentScheduleService) {
        this.paymentScheduleService = paymentScheduleService;
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
        CustomerDTO customerFromDb = customerService.findById(newLoanOffer.getCustomerId());
        CreditDTO creditFromDb = creditService.findById(newLoanOffer.getCreditId());
        CalculatedDataAndId loanProcessing = new CalculatedDataAndId();
        List<PaymentScheduleDTO> calculationCredit = paymentScheduleService
                .calculateCredit(creditFromDb.getCreditLimit(),creditFromDb.getInterestRate(),newLoanOffer.getNumberOfYears());
        model.addAttribute("customer", customerFromDb);
        model.addAttribute("calculation_credit", calculationCredit);
        model.addAttribute("credit", creditFromDb);
        model.addAttribute("loan_processing",loanProcessing);
        model.addAttribute("year", newLoanOffer.getNumberOfYears());
        return "loan_offer_create_new_offer";
    }

    @RequestMapping(value = "/create_new/", method = RequestMethod.POST)
    public String createNewLoanAgreement(@ModelAttribute("loan_processing") CalculatedDataAndId loanProcessing){
        CalculatedDataAndId loanOfferId = loanOfferService.save(loanProcessing);
        paymentScheduleService.save(loanOfferId);
        return "redirect:/payment_schedule/";
    }
}
