package com.haulmount.test_task.service;

import com.haulmount.test_task.service.dto.PaymentScheduleDTO;

import java.util.List;
import java.util.UUID;

public interface PaymentScheduleService {

    List<PaymentScheduleDTO> findAll();
    void delete(UUID loanOfferId);
}
