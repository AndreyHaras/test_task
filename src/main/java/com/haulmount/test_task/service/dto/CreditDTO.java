package com.haulmount.test_task.service.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.UUID;

public class CreditDTO {

    private UUID id;

    @NotNull
    @Size(min = 5, max = 11, message = "must be between 5 and 11")
    @Pattern(regexp = "^[0-9]+$")
    private String creditLimit;

    @NotNull
    @Size(min = 2, max = 6, message = "must be between 2 and 6")
    private String interestRate;

    public CreditDTO() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(String creditLimit) {
        this.creditLimit = creditLimit;
    }

    public String getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(String interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CreditDTO creditDTO = (CreditDTO) o;

        if (id != null ? !id.equals(creditDTO.id) : creditDTO.id != null) return false;
        if (creditLimit != null ? !creditLimit.equals(creditDTO.creditLimit) : creditDTO.creditLimit != null)
            return false;
        return interestRate != null ? interestRate.equals(creditDTO.interestRate) : creditDTO.interestRate == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (creditLimit != null ? creditLimit.hashCode() : 0);
        result = 31 * result + (interestRate != null ? interestRate.hashCode() : 0);
        return result;
    }
}
