package com.haulmont.test_task.dao.entity;

import java.time.LocalDate;

public interface PaymentScheduleOrderBy {
    LocalDate getDateOfPay();
    String getMonthlyPayment();
    String getPrincipalPaid();
    String getInterestPaid();
}
