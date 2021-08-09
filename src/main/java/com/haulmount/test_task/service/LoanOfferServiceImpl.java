package com.haulmount.test_task.service;

import com.haulmount.test_task.dao.entity.LoanOffer;
import com.haulmount.test_task.dao.repository.CreditRepository;
import com.haulmount.test_task.dao.repository.CustomerRepository;
import com.haulmount.test_task.dao.repository.LoanOfferRepository;
import com.haulmount.test_task.service.dto.CalculatedDataAndId;
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
    public UUID save(CalculatedDataAndId newLoanOffer) {
        LoanOffer saveOffer = loanOfferRepository.save(saveDataToDb(newLoanOffer));
        return saveOffer.getId();
    }

    private LoanOffer saveDataToDb(CalculatedDataAndId newLoanOffer){
        LoanOffer loanOffer = new LoanOffer();
        loanOffer.setCustomerId(newLoanOffer.getCustomerId());
        loanOffer.setCreditId(newLoanOffer.getCreditId());
        loanOffer.setCreditAmount(newLoanOffer.getCurrentAmount());
        return loanOffer;
    }
}
