package com.haulmount.test_task.dao.repository;

import com.haulmount.test_task.dao.entity.Credit;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface CreditRepository extends JpaRepository<Credit, UUID> {
}
