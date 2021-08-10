package com.haulmont.test_task.service.calculationOfLoanPayment;

import com.haulmont.test_task.service.dto.PaymentScheduleDTO;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.*;

public class CalculationOfLoanPayments {

    private List<PaymentScheduleDTO> paymentScheduleList = new ArrayList<>();
    private int month, numberOfYear,totalMonths;
    private double monthlyPayment, monthlyInterestRate;
    private double interestPaid, principalPaid, newBalance;
    private double annualInterestRate;
    private double principal;
    private DecimalFormat decimalFormat = new DecimalFormat( "#.##" );

    public CalculationOfLoanPayments(double principal, double annualInterestRate, int numberOfYear) {
        this.numberOfYear = numberOfYear;
        this.annualInterestRate = annualInterestRate;
        this.principal = principal;
    }

    public List<PaymentScheduleDTO> getResult(){return this.paymentScheduleList;}

    public void calculatePayment(){
        totalMonths = numberOfYear * 12;
        monthlyInterestRate = annualInterestRate / 12;
        monthlyPayment = monthlyPayment(principal, monthlyInterestRate, numberOfYear);
        for (month = 1; month <= totalMonths; month++) {
            LocalDate localDate = LocalDate.now();
            if(month != 1){
                localDate = localDate.plusDays(month * 30);
            }
            interestPaid  = principal      * (monthlyInterestRate / 100);
            principalPaid = monthlyPayment - interestPaid;
            newBalance    = principal      - principalPaid;

            paymentScheduleList.add(calculationData(decimalFormat.format(monthlyPayment),
                    decimalFormat.format(monthlyPayment*totalMonths), localDate, decimalFormat.format(interestPaid),
                    decimalFormat.format(principalPaid), decimalFormat.format(newBalance)));

            principal = newBalance;
        }

    }

    private double monthlyPayment(double loanAmount, double monthlyInterestRate, int numberOfYears) {
        monthlyInterestRate /= 100;  // e.g. 5% => 0.05
        return loanAmount * monthlyInterestRate /
                ( 1 - 1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12) );
    }

    private PaymentScheduleDTO calculationData(String monthlyPayment, String totalPayment, LocalDate dateOfPay,
                                               String interestPaid, String principalPaid, String totalSum){
        PaymentScheduleDTO calculatedData= new PaymentScheduleDTO();
        calculatedData.setMonthlyPayment(monthlyPayment);
        calculatedData.setTotalPayment(totalPayment);
        calculatedData.setDateOfPay(dateOfPay);
        calculatedData.setInterestPaid(interestPaid);
        calculatedData.setPrincipalPaid(principalPaid);
        calculatedData.setTotalSum(totalSum);
        return calculatedData;
    }
}
