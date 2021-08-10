package com.haulmount.test_task.dao.entity;

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
    private UUID idCustomer;

    @Column(name = "uuid_credit")
    private UUID idCredit;

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
        if (idCustomer != null ? !idCustomer.equals(bank.idCustomer) : bank.idCustomer != null) return false;
        return idCredit != null ? idCredit.equals(bank.idCredit) : bank.idCredit == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (idCustomer != null ? idCustomer.hashCode() : 0);
        result = 31 * result + (idCredit != null ? idCredit.hashCode() : 0);
        return result;
    }
}
