package com.haulmount.test_task.service;

import com.haulmount.test_task.service.dto.CreditDTO;

import java.util.List;

public interface CreditService {

    List<CreditDTO> findAll();
    void save(CreditDTO credit);
    void delete(CreditDTO credit);
}
