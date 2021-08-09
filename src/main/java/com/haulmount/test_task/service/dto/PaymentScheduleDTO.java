package com.haulmount.test_task.service.dto;

import java.util.UUID;

public class PaymentScheduleDTO {

    private UUID loanOfferId;

    private String dateOfPay;

    private String monthlyPayment;

    private String principalPaid;

    private String interestPaid;

    private String totalPayment;

    public PaymentScheduleDTO() {
    }

    public UUID getLoanOfferId() {
        return loanOfferId;
    }

    public void setLoanOfferId(UUID loanOfferId) {
        this.loanOfferId = loanOfferId;
    }

    public String getDateOfPay() {
        return dateOfPay;
    }

    public void setDateOfPay(String dateOfPay) {
        this.dateOfPay = dateOfPay;
    }

    public String getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(String monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public String getPrincipalPaid() {
        return principalPaid;
    }

    public void setPrincipalPaid(String principalPaid) {
        this.principalPaid = principalPaid;
    }

    public String getInterestPaid() {
        return interestPaid;
    }

    public void setInterestPaid(String interestPaid) {
        this.interestPaid = interestPaid;
    }

    public String getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(String totalPayment) {
        this.totalPayment = totalPayment;
    }
}
