package com.haulmount.test_task.service;

import com.haulmount.test_task.dao.entity.LoanOffer;
import com.haulmount.test_task.dao.repository.LoanOfferRepository;
import com.haulmount.test_task.service.dto.CalculatedDataAndId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanOfferServiceImpl implements LoanOfferService {

    private LoanOfferRepository loanOfferRepository;

    @Autowired
    public void setRepository(LoanOfferRepository loanOfferRepository) {
        this.loanOfferRepository = loanOfferRepository;
    }

    @Override
    public CalculatedDataAndId save(CalculatedDataAndId newLoanOffer) {
        LoanOffer saveOffer = loanOfferRepository.save(saveDataToDb(newLoanOffer));
        newLoanOffer.setLoanOfferId(saveOffer.getId());
        return newLoanOffer;

    }

    private LoanOffer saveDataToDb(CalculatedDataAndId newLoanOffer){
        LoanOffer loanOffer = new LoanOffer();
        loanOffer.setCustomerId(newLoanOffer.getCustomerId());
        loanOffer.setCreditId(newLoanOffer.getCreditId());
        loanOffer.setCreditAmount(newLoanOffer.getPrincipal());
        return loanOffer;
    }
}
