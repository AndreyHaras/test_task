package com.haulmount.test_task.service.dto;

import java.util.UUID;

public class LoanOfferDTO {

    private UUID id;
    private UUID customerId;
    private UUID creditId;
    private String CreditAmount;
    private String numberOfYears;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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

    public String getCreditAmount() {
        return CreditAmount;
    }

    public void setCreditAmount(String creditAmount) {
        CreditAmount = creditAmount;
    }

    public String getNumberOfYears() {
        return numberOfYears;
    }

    public void setNumberOfYears(String numberOfYears) {
        this.numberOfYears = numberOfYears;
    }
}
