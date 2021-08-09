package com.haulmount.test_task.service;

import com.haulmount.test_task.service.dto.CalculatedDataAndId;

import java.util.UUID;

public interface LoanOfferService {

    UUID save(CalculatedDataAndId newLoanOffer);
}
