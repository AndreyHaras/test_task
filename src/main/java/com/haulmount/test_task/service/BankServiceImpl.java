package com.haulmount.test_task.service;

import com.haulmount.test_task.dao.entity.Bank;
import com.haulmount.test_task.dao.entity.Credit;
import com.haulmount.test_task.dao.entity.Customer;
import com.haulmount.test_task.dao.repository.BankRepository;
import com.haulmount.test_task.service.dto.BankDTO;
import com.haulmount.test_task.service.dto.CreditDTO;
import com.haulmount.test_task.service.dto.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BankServiceImpl implements BankService {

    private BankRepository repository;

    @Autowired
    public void setRepository(BankRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<BankDTO> findAll() {
        return createBankList(repository.findAll());
    }

    @Override
    public void save(BankDTO bank) {
        repository.save(bankToDb(bank));
    }

    @Override
    public void delete(UUID bankId) {
        repository.deleteById(bankId);
    }

    private List<BankDTO> createBankList(List<Bank> banks){
        List<BankDTO> result = new ArrayList<>();
        for(Bank bank : banks){
            BankDTO newBank = new BankDTO();
            newBank.setId(bank.getId());
            newBank.setCredit(createCreditDto(bank.getCredit()));
            newBank.setCustomer(createCustomerDto(bank.getCustomer()));
            result.add(newBank);
        }
        return result;
    }

    private Bank bankToDb(BankDTO bank){
        Bank bankToDb = new Bank();
        bankToDb.setIdCredit(bank.getCredit_id());
        bankToDb.setIdCustomer(bank.getCustomer_id());
        return bankToDb;
    }

    private CreditDTO createCreditDto(Credit credit){
        CreditDTO newCredit = new CreditDTO();
        newCredit.setId(credit.getId());
        newCredit.setInterestRate(credit.getInterestRate());
        newCredit.setCreditLimit(credit.getCreditLimit());
        return newCredit;
    }

    private CustomerDTO createCustomerDto(Customer customer){
        CustomerDTO newCustomer = new CustomerDTO();
        newCustomer.setId(customer.getId());
        newCustomer.setEmail(customer.getEmail());
        newCustomer.setFullyQualifiedName(customer.getFullyQualifiedName());
        newCustomer.setPassportNumber(customer.getPassportNumber());
        newCustomer.setPhoneNumber(customer.getPhoneNumber());
        return newCustomer;
    }
}
