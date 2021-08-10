package com.haulmount.test_task.dao.repository;

import com.haulmount.test_task.dao.entity.PaymentSchedule;
import com.haulmount.test_task.dao.entity.PaymentScheduleOrderBy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.UUID;

public interface PaymentScheduleRepository extends JpaRepository<PaymentSchedule, UUID> {
    void deleteByLoanOfferId(UUID loanOfferId);
    @Query("Select p.dateOfPay as dateOfPay, " +
            "p.monthlyPayment as monthlyPayment, " +
            "p.principalPaid as principalPaid, " +
            "p.interestPaid as interestPaid " +
            "From PaymentSchedule p order by p.dateOfPay asc")
    List<PaymentScheduleOrderBy> findAllOrderBy();
}
