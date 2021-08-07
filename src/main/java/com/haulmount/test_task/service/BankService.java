package com.haulmount.test_task.service;

import com.haulmount.test_task.service.dto.BankDTO;

import java.util.List;

public interface BankService {
    List<BankDTO> findAll();
}
