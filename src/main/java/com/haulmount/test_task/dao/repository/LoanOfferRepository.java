package com.haulmount.test_task.dao.repository;

import com.haulmount.test_task.dao.entity.LoanOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface LoanOfferRepository extends JpaRepository<LoanOffer, UUID> {
}
