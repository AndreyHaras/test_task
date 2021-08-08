package com.haulmount.test_task.service;

import com.haulmount.test_task.dao.entity.Credit;
import com.haulmount.test_task.dao.repository.CreditRepository;
import com.haulmount.test_task.service.dto.CreditDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CreditServiceImpl implements CreditService {

    private CreditRepository repository;

    @Autowired
    public void setRepository(CreditRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<CreditDTO> findAll() {
        return createCreditList(repository.findAll());
    }

    @Override
    public void save(CreditDTO credit) {
        repository.save(creditToDb(credit));
    }

    @Override
    public void delete(CreditDTO credit) {
        repository.delete(creditToDelete(credit));
    }

    private List<CreditDTO> createCreditList(List<Credit> credits){
        List<CreditDTO> result = new ArrayList<>();
        for (Credit credit : credits){
            CreditDTO newCredit = new CreditDTO();
            newCredit.setId(credit.getId());
            newCredit.setCreditLimit(credit.getCreditLimit());
            newCredit.setInterestRate(credit.getInterestRate());
            result.add(newCredit);
        }
        return result;
    }
    private Credit creditToDb(CreditDTO credit){
        Credit creditToDb = new Credit();
        creditToDb.setCreditLimit(credit.getCreditLimit());
        creditToDb.setInterestRate(credit.getInterestRate());
        return creditToDb;
    }
    private Credit creditToDelete(CreditDTO credit){
        Credit creditToDb = new Credit();
        creditToDb.setCreditLimit(credit.getCreditLimit());
        creditToDb.setInterestRate(credit.getInterestRate());
        creditToDb.setId(credit.getId());
        return creditToDb;
    }
}
