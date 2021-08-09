package com.haulmount.test_task.service;

import com.haulmount.test_task.dao.repository.CreditRepository;
import com.haulmount.test_task.dao.repository.CustomerRepository;
import com.haulmount.test_task.dao.repository.LoanOfferRepository;
import com.haulmount.test_task.service.dto.LoanOfferDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LoanOfferServiceImpl implements LoanOfferService {

    private LoanOfferRepository loanOfferRepository;

    @Autowired
    public void setRepository(LoanOfferRepository loanOfferRepository) {
        this.loanOfferRepository = loanOfferRepository;
    }

    @Override
    public void save(LoanOfferDTO newLoanOffer) {

    }
}
