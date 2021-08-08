package com.haulmount.test_task.service.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.UUID;

public class CreditDTO {

    private UUID id;

    @NotNull
    @Size(min = 5, max = 10, message = "must be between 5 and 10 characters")
    @Pattern(regexp = "[0-9]", message = "only numbers available")
    private double creditLimit;

    @NotNull
    @Size(min = 2, max = 5, message = "must be between 2 and 5")
    private double interestRate;

    public CreditDTO() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
}
