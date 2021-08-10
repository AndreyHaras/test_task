package com.haulmont.test_task.dao.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "bank")
public class Bank {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    @Column(name = "uuid_customer")
    private UUID customerId;

    @Column(name = "uuid_credit")
    private UUID creditId;

    @ManyToOne
    @JoinColumn(name = "uuid_customer", insertable = false,updatable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "uuid_credit", insertable = false,updatable = false)
    private Credit credit;

    public Bank() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID idCustomer) {
        this.customerId = idCustomer;
    }

    public UUID getCreditId() {
        return creditId;
    }

    public void setCreditId(UUID idCredit) {
        this.creditId = idCredit;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Credit getCredit() {
        return credit;
    }

    public void setCredit(Credit credit) {
        this.credit = credit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bank bank = (Bank) o;

        if (id != null ? !id.equals(bank.id) : bank.id != null) return false;
        if (customerId != null ? !customerId.equals(bank.customerId) : bank.customerId != null) return false;
        return creditId != null ? creditId.equals(bank.creditId) : bank.creditId == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (customerId != null ? customerId.hashCode() : 0);
        result = 31 * result + (creditId != null ? creditId.hashCode() : 0);
        return result;
    }
}
