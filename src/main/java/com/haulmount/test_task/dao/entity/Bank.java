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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "uuid_customer",
            referencedColumnName = "id", insertable = false,updatable = false)
    private Customer customer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "uuid_credit",
            referencedColumnName = "id", insertable = false,updatable = false)
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
}
