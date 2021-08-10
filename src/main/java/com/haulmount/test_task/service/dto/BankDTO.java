package com.haulmount.test_task.service.dto;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public class BankDTO {

    private UUID id;

    @NotNull
    private UUID customerId;

    @NotNull
    private UUID creditId;

    private CustomerDTO customer;

    private CreditDTO credit;

    public BankDTO() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    public CreditDTO getCredit() {
        return credit;
    }

    public void setCredit(CreditDTO credit) {
        this.credit = credit;
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
}
