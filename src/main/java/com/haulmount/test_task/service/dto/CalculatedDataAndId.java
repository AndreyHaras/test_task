package com.haulmount.test_task.service.dto;

import java.util.UUID;

public class CalculatedDataAndId {
    private UUID customerId;
    private UUID creditId;
    private String year;
    private String principal;
    private String interestRate;
    private UUID loanOfferId;

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }

    public UUID getCreditId() {
        return creditId;
    }

    public void setCreditId(UUID creditId) {
        this.creditId = creditId;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(String interestRate) {
        this.interestRate = interestRate;
    }

    public UUID getLoanOfferId() {
        return loanOfferId;
    }

    public void setLoanOfferId(UUID loanOfferId) {
        this.loanOfferId = loanOfferId;
    }
}
