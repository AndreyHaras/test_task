package com.haulmount.test_task.web.controllers;

import com.haulmount.test_task.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/credit")
public class CreditController {

    private CreditService service;

    @Autowired
    public void setService(CreditService service) {
        this.service = service;
    }

    
}
