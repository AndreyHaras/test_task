package com.haulmount.test_task.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface BankRepository extends JpaRepository<BankRepository, UUID> {
}
