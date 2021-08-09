package com.haulmount.test_task.service;

import com.haulmount.test_task.dao.entity.Credit;
import com.haulmount.test_task.dao.repository.CreditRepository;
import com.haulmount.test_task.service.dto.CreditDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CreditServiceImpl implements CreditService {

    private CreditRepository repository;

    @Autowired
    public void setRepository(CreditRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean checkCredit(UUID creditId) {
        return repository.findById(creditId).get().getBank() != null;
    }

    @Override
    public CreditDTO findById(UUID creditId) {
        return findCredit(repository.findById(creditId));
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
    public void delete(UUID creditId) {
        repository.deleteById(creditId);
    }

    private CreditDTO findCredit(Optional<Credit> creditFromDb){
        Credit credit = creditFromDb.get();
        CreditDTO creditDTO = new CreditDTO();
        creditDTO.setCreditLimit(credit.getCreditLimit());
        creditDTO.setInterestRate(credit.getInterestRate());
        return creditDTO;
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

}
