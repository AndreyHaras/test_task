package com.haulmount.test_task.service;

import com.haulmount.test_task.dao.entity.PaymentSchedule;
import com.haulmount.test_task.dao.entity.PaymentScheduleOrderBy;
import com.haulmount.test_task.dao.repository.PaymentScheduleRepository;
import com.haulmount.test_task.service.dto.PaymentScheduleDTO;
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
}
