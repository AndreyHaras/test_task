package com.haulmont.test_task.service;

import com.haulmont.test_task.service.dto.CreditDTO;

import java.util.List;
import java.util.UUID;

public interface CreditService {
    boolean checkCredit(UUID creditId);
    CreditDTO findById(UUID creditId);
    List<CreditDTO> findAll();
    void save(CreditDTO credit);
    void delete(UUID creditId);
}
