package com.haulmont.test_task.dao.repository;

import com.haulmont.test_task.dao.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
}
