package com.haulmont.test_task.service.dto;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LoanOfferDTO that = (LoanOfferDTO) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (customerId != null ? !customerId.equals(that.customerId) : that.customerId != null) return false;
        if (creditId != null ? !creditId.equals(that.creditId) : that.creditId != null) return false;
        if (CreditAmount != null ? !CreditAmount.equals(that.CreditAmount) : that.CreditAmount != null) return false;
        return numberOfYears != null ? numberOfYears.equals(that.numberOfYears) : that.numberOfYears == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (customerId != null ? customerId.hashCode() : 0);
        result = 31 * result + (creditId != null ? creditId.hashCode() : 0);
        result = 31 * result + (CreditAmount != null ? CreditAmount.hashCode() : 0);
        result = 31 * result + (numberOfYears != null ? numberOfYears.hashCode() : 0);
        return result;
    }
}
