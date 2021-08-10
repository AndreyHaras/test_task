package com.haulmont.test_task.service.dto;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BankDTO bankDTO = (BankDTO) o;

        if (id != null ? !id.equals(bankDTO.id) : bankDTO.id != null) return false;
        if (customerId != null ? !customerId.equals(bankDTO.customerId) : bankDTO.customerId != null) return false;
        return creditId != null ? creditId.equals(bankDTO.creditId) : bankDTO.creditId == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (customerId != null ? customerId.hashCode() : 0);
        result = 31 * result + (creditId != null ? creditId.hashCode() : 0);
        return result;
    }
}
