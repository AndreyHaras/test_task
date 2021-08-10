package com.haulmont.test_task.service;

import com.haulmont.test_task.service.dto.BankDTO;
import com.haulmont.test_task.service.dto.CalculatedDataAndId;

import java.util.List;
import java.util.UUID;

public interface BankService {
    List<BankDTO> findAll();
    void saveNewLoanOffer(CalculatedDataAndId loanOfferId);
    void save(BankDTO bank);
    void delete(UUID bankId);
}
