package com.haulmount.test_task.service;

import com.haulmount.test_task.service.dto.CalculatedDataAndId;

public interface LoanOfferService {

    CalculatedDataAndId save(CalculatedDataAndId newLoanOffer);
}
