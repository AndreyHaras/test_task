package com.haulmount.test_task.service;

import com.haulmount.test_task.dao.repository.CreditRepository;
import com.haulmount.test_task.service.dto.CreditDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
        return null;
    }

    @Override
    public void save(CreditDTO credit) {

    }

    @Override
    public void delete(CreditDTO credit) {

    }
}
