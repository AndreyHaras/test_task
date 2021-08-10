package com.haulmont.test_task.dao.repository;

import com.haulmont.test_task.dao.entity.LoanOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface LoanOfferRepository extends JpaRepository<LoanOffer, UUID> {
    LoanOffer findByCreditIdAndCustomerId(UUID creditId, UUID customerId);
}
