package com.haulmont.test_task.dao.entity;

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

    @OneToMany(mappedBy = "loanOffer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PaymentSchedule> paymentSchedules;

    @ManyToOne
    @JoinColumn(name = "uuid_customer",
            referencedColumnName = "id", insertable = false,updatable = false)
    private Customer customer;

    @OneToOne
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LoanOffer loanOffer = (LoanOffer) o;

        if (id != null ? !id.equals(loanOffer.id) : loanOffer.id != null) return false;
        if (customerId != null ? !customerId.equals(loanOffer.customerId) : loanOffer.customerId != null) return false;
        if (creditId != null ? !creditId.equals(loanOffer.creditId) : loanOffer.creditId != null) return false;
        return CreditAmount != null ? CreditAmount.equals(loanOffer.CreditAmount) : loanOffer.CreditAmount == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (customerId != null ? customerId.hashCode() : 0);
        result = 31 * result + (creditId != null ? creditId.hashCode() : 0);
        result = 31 * result + (CreditAmount != null ? CreditAmount.hashCode() : 0);
        return result;
    }
}
