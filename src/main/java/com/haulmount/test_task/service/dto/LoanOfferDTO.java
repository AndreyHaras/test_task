package com.haulmount.test_task.service.dto;

import com.haulmount.test_task.dao.entity.Credit;
import com.haulmount.test_task.dao.entity.Customer;
import com.haulmount.test_task.dao.entity.PaymentSchedule;

import java.util.List;

public class LoanOfferDTO {
    private CreditDTO credit;
    private CustomerDTO customer;
    private List<PaymentScheduleDTO> paymentSchedules;
}
