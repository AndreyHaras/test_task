package com.haulmont.test_task.service;

import com.haulmont.test_task.service.dto.CalculatedDataAndId;

import java.util.UUID;

public interface LoanOfferService {
    boolean checkIfOfferAlreadyExist(CalculatedDataAndId dataAndId);
    CalculatedDataAndId save(CalculatedDataAndId newLoanOffer);
    void deleteCreditRecord(UUID bankId);
}
