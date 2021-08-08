package com.haulmount.test_task.dao.repository;

import com.haulmount.test_task.dao.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface BankRepository extends JpaRepository<Bank, UUID> {
}
