package com.haulmount.test_task.web.controllers;

import com.haulmount.test_task.service.PaymentScheduleService;
import com.haulmount.test_task.service.dto.PaymentScheduleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/payment_schedule")
public class PaymentScheduleController {

    private PaymentScheduleService service;

    @Autowired
    public void setService(PaymentScheduleService service) {
        this.service = service;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String paymentScheduleMainPage(Model model){
        List<PaymentScheduleDTO> payments = service.findAll();
        model.addAttribute("payments", payments);
        return "payment_schedule_page";
    }
}
