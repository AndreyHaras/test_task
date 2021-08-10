package com.haulmount.test_task.service;

import com.haulmount.test_task.dao.entity.Bank;
import com.haulmount.test_task.dao.entity.LoanOffer;
import com.haulmount.test_task.dao.repository.BankRepository;
import com.haulmount.test_task.dao.repository.LoanOfferRepository;
import com.haulmount.test_task.service.dto.CalculatedDataAndId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LoanOfferServiceImpl implements LoanOfferService {

    private LoanOfferRepository loanOfferRepository;
    private BankRepository bankRepository;

    @Autowired
    public void setRepository(LoanOfferRepository loanOfferRepository) {
        this.loanOfferRepository = loanOfferRepository;
    }

    @Autowired
    public void setBankRepository(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    @Override
    public CalculatedDataAndId save(CalculatedDataAndId newLoanOffer) {
        LoanOffer saveOffer = loanOfferRepository.save(saveDataToDb(newLoanOffer));
        newLoanOffer.setLoanOfferId(saveOffer.getId());
        return newLoanOffer;

    }

    @Override
    public void deleteCreditRecord(UUID bankId) {
        Bank recordInBank = bankRepository.findById(bankId).get();
        LoanOffer offerToDelete = loanOfferRepository.findByCreditIdAndCustomerId(recordInBank.getIdCredit(), recordInBank.getIdCustomer());
        loanOfferRepository.deleteById(offerToDelete.getId());
    }

    private LoanOffer saveDataToDb(CalculatedDataAndId newLoanOffer){
        LoanOffer loanOffer = new LoanOffer();
        loanOffer.setCustomerId(newLoanOffer.getCustomerId());
        loanOffer.setCreditId(newLoanOffer.getCreditId());
        loanOffer.setCreditAmount(newLoanOffer.getPrincipal());
        return loanOffer;
    }
}
