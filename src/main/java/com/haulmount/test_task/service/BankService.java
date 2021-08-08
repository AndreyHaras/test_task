package com.haulmount.test_task.service;

import com.haulmount.test_task.service.dto.BankDTO;
import java.util.List;
import java.util.UUID;

public interface BankService {

    List<BankDTO> findAll();
    void save(BankDTO bank);
    void delete(UUID bankId);
}
