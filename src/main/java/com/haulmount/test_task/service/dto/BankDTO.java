package com.haulmount.test_task.service.dto;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public class BankDTO {

    private UUID id;

    @NotNull
    private UUID customer_id;

    @NotNull
    private UUID credit_id;

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

    public UUID getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(UUID customer_id) {
        this.customer_id = customer_id;
    }

    public UUID getCredit_id() {
        return credit_id;
    }

    public void setCredit_id(UUID credit_id) {
        this.credit_id = credit_id;
    }
}
