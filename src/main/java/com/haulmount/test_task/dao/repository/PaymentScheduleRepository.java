package com.haulmount.test_task.dao.repository;

import com.haulmount.test_task.dao.entity.PaymentSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface PaymentScheduleRepository extends JpaRepository<PaymentSchedule, UUID> {
}
