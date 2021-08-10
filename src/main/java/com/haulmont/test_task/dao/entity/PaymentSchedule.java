package com.haulmont.test_task.dao.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "payment_schedule")
public class PaymentSchedule {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    @Column(name = "loan_offer_id")
    private UUID loanOfferId;

    @Column(name = "date_of_pay")
    private LocalDate dateOfPay;

    @Column(name = "monthly_payment")
    private String monthlyPayment;

    @Column(name = "principal_paid")
    private String principalPaid;

    @Column(name = "interest_paid")
    private String interestPaid;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "loan_offer_id", updatable = false, insertable = false)
    private LoanOffer loanOffer;

    public PaymentSchedule() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getLoanOfferId() {
        return loanOfferId;
    }

    public void setLoanOfferId(UUID loanOfferId) {
        this.loanOfferId = loanOfferId;
    }

    public LocalDate getDateOfPay() {
        return dateOfPay;
    }

    public void setDateOfPay(LocalDate dateOfPay) {
        this.dateOfPay = dateOfPay;
    }

    public String getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(String monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public String getPrincipalPaid() {
        return principalPaid;
    }

    public void setPrincipalPaid(String principalPaid) {
        this.principalPaid = principalPaid;
    }

    public String getInterestPaid() {
        return interestPaid;
    }

    public void setInterestPaid(String interestPaid) {
        this.interestPaid = interestPaid;
    }

    public LoanOffer getLoanOffer() {
        return loanOffer;
    }

    public void setLoanOffer(LoanOffer loanOffer) {
        this.loanOffer = loanOffer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PaymentSchedule that = (PaymentSchedule) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (loanOfferId != null ? !loanOfferId.equals(that.loanOfferId) : that.loanOfferId != null) return false;
        if (dateOfPay != null ? !dateOfPay.equals(that.dateOfPay) : that.dateOfPay != null) return false;
        if (monthlyPayment != null ? !monthlyPayment.equals(that.monthlyPayment) : that.monthlyPayment != null)
            return false;
        if (principalPaid != null ? !principalPaid.equals(that.principalPaid) : that.principalPaid != null)
            return false;
        return interestPaid != null ? interestPaid.equals(that.interestPaid) : that.interestPaid == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (loanOfferId != null ? loanOfferId.hashCode() : 0);
        result = 31 * result + (dateOfPay != null ? dateOfPay.hashCode() : 0);
        result = 31 * result + (monthlyPayment != null ? monthlyPayment.hashCode() : 0);
        result = 31 * result + (principalPaid != null ? principalPaid.hashCode() : 0);
        result = 31 * result + (interestPaid != null ? interestPaid.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PaymentSchedule{" +
                "id=" + id +
                ", loanOfferId=" + loanOfferId +
                ", dateOfPay=" + dateOfPay +
                ", monthlyPayment='" + monthlyPayment + '\'' +
                ", principalPaid='" + principalPaid + '\'' +
                ", interestPaid='" + interestPaid + '\'' +
                ", loanOffer=" + loanOffer +
                '}';
    }
}
