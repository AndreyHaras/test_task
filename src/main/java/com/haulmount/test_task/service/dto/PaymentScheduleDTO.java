package com.haulmount.test_task.service.dto;

import java.util.UUID;

public class PaymentScheduleDTO {

    private UUID loanOfferId;

    private String dateOfPay;

    private String monthlyPayment;

    private String principalPaid;

    private String interestPaid;

    private String totalPayment;

    private String totalSum;

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

    public String getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(String totalSum) {
        this.totalSum = totalSum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PaymentScheduleDTO that = (PaymentScheduleDTO) o;

        if (loanOfferId != null ? !loanOfferId.equals(that.loanOfferId) : that.loanOfferId != null) return false;
        if (dateOfPay != null ? !dateOfPay.equals(that.dateOfPay) : that.dateOfPay != null) return false;
        if (monthlyPayment != null ? !monthlyPayment.equals(that.monthlyPayment) : that.monthlyPayment != null)
            return false;
        if (principalPaid != null ? !principalPaid.equals(that.principalPaid) : that.principalPaid != null)
            return false;
        if (interestPaid != null ? !interestPaid.equals(that.interestPaid) : that.interestPaid != null) return false;
        if (totalPayment != null ? !totalPayment.equals(that.totalPayment) : that.totalPayment != null) return false;
        return totalSum != null ? totalSum.equals(that.totalSum) : that.totalSum == null;
    }

    @Override
    public int hashCode() {
        int result = loanOfferId != null ? loanOfferId.hashCode() : 0;
        result = 31 * result + (dateOfPay != null ? dateOfPay.hashCode() : 0);
        result = 31 * result + (monthlyPayment != null ? monthlyPayment.hashCode() : 0);
        result = 31 * result + (principalPaid != null ? principalPaid.hashCode() : 0);
        result = 31 * result + (interestPaid != null ? interestPaid.hashCode() : 0);
        result = 31 * result + (totalPayment != null ? totalPayment.hashCode() : 0);
        result = 31 * result + (totalSum != null ? totalSum.hashCode() : 0);
        return result;
    }
}
