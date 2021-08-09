package com.haulmount.test_task.dao.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "loan_offer")
public class LoanOffer {

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

    @Column(name = "credit_amount")
    private String CreditAmount;

    @OneToMany(mappedBy = "loanOffer", fetch = FetchType.LAZY)
    private List<PaymentSchedule> paymentSchedules;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "uuid_customer",
            referencedColumnName = "id", insertable = false,updatable = false)
    private Customer customer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "uuid_credit",
            referencedColumnName = "id", insertable = false, updatable = false)
    private Credit credit;

    public LoanOffer() {
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

    public List<PaymentSchedule> getPaymentSchedules() {
        return paymentSchedules;
    }

    public void setPaymentSchedules(List<PaymentSchedule> paymentSchedules) {
        this.paymentSchedules = paymentSchedules;
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
