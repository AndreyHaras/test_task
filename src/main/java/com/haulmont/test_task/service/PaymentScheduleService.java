package com.haulmont.test_task.service;

import com.haulmont.test_task.service.dto.CalculatedDataAndId;
import com.haulmont.test_task.service.dto.PaymentScheduleDTO;

import java.util.List;
import java.util.UUID;

public interface PaymentScheduleService {
    List<PaymentScheduleDTO> calculateCredit(String principal, String interestRate, String year);
    List<PaymentScheduleDTO> findAll();
    void delete(UUID loanOfferId);
    void save(CalculatedDataAndId loanOffer);
}
