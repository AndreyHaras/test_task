package com.haulmount.test_task.service.dto;

import java.util.UUID;

public class BankDTO {

    private UUID id;
    private CustomerDTO customer;
    private CreditDTO credit;
    private UUID idCustomer;
    private UUID idCredit;

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

    public UUID getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(UUID idCustomer) {
        this.idCustomer = idCustomer;
    }

    public UUID getIdCredit() {
        return idCredit;
    }

    public void setIdCredit(UUID idCredit) {
        this.idCredit = idCredit;
    }
}
