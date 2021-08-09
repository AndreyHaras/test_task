package com.haulmount.test_task.service;

import com.haulmount.test_task.dao.repository.LoanOfferRepository;
import com.haulmount.test_task.service.dto.LoanOfferDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanOfferServiceImpl implements LoanOfferService {

    private LoanOfferRepository repository;

    @Autowired
    public void setRepository(LoanOfferRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(LoanOfferDTO newLoanOffer) {

    }
}
