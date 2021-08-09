package com.haulmount.test_task.service.calculationOfLoanPayment;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class CalculationOfLoanPayments {

    private Map<String, List<String>> resuilList = new HashMap<>();
    private int month, numberOfYear,totalMonths;
    private double monthlyPayment, monthlyInterestRate;
    private double interestPaid, principalPaid, newBalance;
    private double annualInterestRate;
    private double principal;
    private DecimalFormat decimalFormat = new DecimalFormat( "#.##" );

    public CalculationOfLoanPayments(int numberOfYear, double annualInterestRate, double principal) {
        this.numberOfYear = numberOfYear;
        this.annualInterestRate = annualInterestRate;
        this.principal = principal;
    }

    public Map<String, List<String>> getResuilList() {
        return resuilList;
    }
    // Output monthly payment and total payment
    public void calculatePayment(){
        totalMonths = numberOfYear * 12;
        monthlyInterestRate = annualInterestRate / 12;
        monthlyPayment      = monthlyPayment(principal, monthlyInterestRate, 15);

        resuilList.put("monthlyPayment",
                new ArrayList<>(Arrays.asList(decimalFormat.format(monthlyPayment))));
        resuilList.put("totalPayment",
                new ArrayList<>(Arrays.asList(decimalFormat.format(decimalFormat.format(monthlyPayment*totalMonths)))));

        System.out.format("Monthly Payment: %8.2f%n", monthlyPayment);
        System.out.format("Total Payment:   %8.2f%n", monthlyPayment*totalMonths);

        // Print the table header
        printTableHeader();

        List<String> interestPaids = new ArrayList<>();
        List<String> principalPaids = new ArrayList<>();
        List<String> newBalances = new ArrayList<>();
        List<String> dateOfPays = new ArrayList<>();
        for (month = 1; month <= totalMonths; month++) {
            // Compute amount paid and new balance for each payment period
            Date date = new Date();
            SimpleDateFormat ft = new SimpleDateFormat("MM-dd-YYYY");
            if(month != 1){
                date = DateUtil.addDays(date, 30 * month);
            }
            interestPaid  = principal      * (monthlyInterestRate / 100);
            principalPaid = monthlyPayment - interestPaid;
            newBalance    = principal      - principalPaid;

            dateOfPays.add(ft.format(date));
            interestPaids.add(decimalFormat.format(interestPaid));
            principalPaids.add(decimalFormat.format(principalPaid));
            newBalances.add(decimalFormat.format(newBalance));


            // Output the data item
            printScheduleItem(date, interestPaid, principalPaid, newBalance);

            // Update the balance
            principal = newBalance;
        }
        resuilList.put("interestPaids",interestPaids);
        resuilList.put("principalPaids", principalPaids);
        resuilList.put("newBalances", newBalances);
        resuilList.put("dateOfPays", dateOfPays);
    }

    private double monthlyPayment(double loanAmount, double monthlyInterestRate, int numberOfYears) {
        monthlyInterestRate /= 100;  // e.g. 5% => 0.05
        return loanAmount * monthlyInterestRate /
                ( 1 - 1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12) );
    }

    /**
     * Prints a table data of the amortization schedule as a table row.
     */
    private void printScheduleItem(Date month, double interestPaid,
                                          double principalPaid, double newBalance) {
        System.out.format("%tF%10.2f%10.2f%12.2f\n",
                month, interestPaid, principalPaid, newBalance);
    }

    /**
     * Prints the table header for the amortization schedule.
     */
    private void printTableHeader() {
        System.out.println("\nAmortization schedule");
        for(int i = 0; i < 40; i++) {  // Draw a line
            System.out.print("-");
        }
        System.out.format("\n%8s%10s%10s%12s\n",
                "Payment", "Interest", "Principal", "Balance");
        System.out.format("%8s%10s%10s%12s\n\n",
                "", "paid", "paid", "");
    }
}
