package com.haulmount.test_task.service;

import com.haulmount.test_task.dao.repository.BankRepository;
import com.haulmount.test_task.service.dto.BankDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BankServiceImpl implements BankService {

    private BankRepository repository;

    @Autowired
    public void setRepository(BankRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<BankDTO> findAll() {
        return null;
    }

}
