package com.haulmount.test_task.dao.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
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
    private Date dateOfPay;

    @Column(name = "mouthly_payment")
    private double monthlyPayment;

    @Column(name = "principal_paid")
    private double principalPaid;

    @Column(name = "interest_paid")
    private double interestPaid;

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

    public Date getDateOfPay() {
        return dateOfPay;
    }

    public void setDateOfPay(Date dateOfPay) {
        this.dateOfPay = dateOfPay;
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public double getPrincipalPaid() {
        return principalPaid;
    }

    public void setPrincipalPaid(double principalPaid) {
        this.principalPaid = principalPaid;
    }

    public double getInterestPaid() {
        return interestPaid;
    }

    public void setInterestPaid(double interestPaid) {
        this.interestPaid = interestPaid;
    }

    public LoanOffer getLoanOffer() {
        return loanOffer;
    }

    public void setLoanOffer(LoanOffer loanOffer) {
        this.loanOffer = loanOffer;
    }
}
