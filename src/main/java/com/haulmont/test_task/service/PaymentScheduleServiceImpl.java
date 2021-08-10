package com.haulmont.test_task.service;

import com.haulmont.test_task.dao.entity.PaymentSchedule;
import com.haulmont.test_task.dao.entity.PaymentScheduleOrderBy;
import com.haulmont.test_task.dao.repository.PaymentScheduleRepository;
import com.haulmont.test_task.service.dto.CalculatedDataAndId;
import com.haulmont.test_task.service.dto.PaymentScheduleDTO;
import com.haulmont.test_task.service.calculationOfLoanPayment.CalculationOfLoanPayments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PaymentScheduleServiceImpl implements PaymentScheduleService {

    private PaymentScheduleRepository repository;

    @Autowired
    public void setRepository(PaymentScheduleRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<PaymentScheduleDTO> findAll() {
        return createPaymentScheduleList(repository.findAllOrderBy());
    }

    @Override
    public void delete(UUID loanOfferId) {
        repository.deleteByLoanOfferId(loanOfferId);
    }

    @Override
    public List<PaymentScheduleDTO> calculateCredit(String principal, String interestRate, String year) {
        CalculationOfLoanPayments calculation =
                new CalculationOfLoanPayments(Double.parseDouble(principal), Double.parseDouble(interestRate), Integer.parseInt(year));
        calculation.calculatePayment();
        return calculation.getResult();
    }

    @Override
    public void save(CalculatedDataAndId loanOffer) {
        List<PaymentScheduleDTO> dataToDb =
                calculateCredit(loanOffer.getPrincipal(), loanOffer.getInterestRate(), loanOffer.getYear());
        saveDataToDb(dataToDb, loanOffer.getLoanOfferId());
    }

    private List<PaymentScheduleDTO> createPaymentScheduleList(List<PaymentScheduleOrderBy> paymentSchedules){
        List<PaymentScheduleDTO> result =new ArrayList<>();
        for(PaymentScheduleOrderBy payment : paymentSchedules){
            PaymentScheduleDTO newPaymentSchedule = new PaymentScheduleDTO();
            newPaymentSchedule.setDateOfPay(payment.getDateOfPay());
            newPaymentSchedule.setInterestPaid(payment.getInterestPaid());
            newPaymentSchedule.setMonthlyPayment(payment.getMonthlyPayment());
            newPaymentSchedule.setPrincipalPaid(payment.getPrincipalPaid());
            result.add(newPaymentSchedule);
        }
        return result;
    }

    private void saveDataToDb(List<PaymentScheduleDTO> dataToDb, UUID loanOfferID){
        for (PaymentScheduleDTO payment : dataToDb){
            PaymentSchedule paymentSchedule = new PaymentSchedule();
            paymentSchedule.setLoanOfferId(loanOfferID);
            paymentSchedule.setDateOfPay(payment.getDateOfPay());
            paymentSchedule.setMonthlyPayment(payment.getMonthlyPayment());
            paymentSchedule.setInterestPaid(payment.getInterestPaid());
            paymentSchedule.setPrincipalPaid(payment.getPrincipalPaid());
            repository.save(paymentSchedule);
        }
    }
}
