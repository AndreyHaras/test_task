package com.haulmont.test_task.dao.repository;

import com.haulmont.test_task.dao.entity.PaymentSchedule;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static org.hamcrest.core.Is.is;

@DataJpaTest
class PaymentScheduleRepositoryTest extends Activeprofile {

    @Autowired
    private PaymentScheduleRepository repository;
    private static final Logger logger = LogManager.getLogger("PaymentScheduleRepositoryTest");
    private static PaymentSchedule paymentSchedule;

    @BeforeAll
    public static void setup() {
        PaymentSchedule newPaymentSchedule = new PaymentSchedule();
        newPaymentSchedule.setDateOfPay(LocalDate.now());
        newPaymentSchedule.setInterestPaid("297,88");
        newPaymentSchedule.setLoanOfferId(UUID.fromString("5b50843d-9771-4aa1-9ff0-d3bc8800573a"));
        newPaymentSchedule.setMonthlyPayment("9808,17");
        newPaymentSchedule.setPrincipalPaid("9413,03");
        paymentSchedule = newPaymentSchedule;
    }

    @Test
    public void findAllPaymentSchedule(){
        List<PaymentSchedule> paymentScheduleList = repository.findAll();
        for (PaymentSchedule payment : paymentScheduleList){
            logger.info("find all payment schedule : " +
                    payment.getMonthlyPayment() + " " + payment.getInterestPaid() + " " + payment.getDateOfPay());
        }
        MatcherAssert.assertThat(paymentScheduleList.size(), is(8));
    }

    @Test
    public void saveNewPaymentSchedule(){
        PaymentSchedule paymentScheduleFromDb = repository.save(paymentSchedule);
        logger.info("save new payment schedule in db : " + paymentScheduleFromDb.getMonthlyPayment() + " " + paymentScheduleFromDb.getDateOfPay());
        MatcherAssert.assertThat(paymentScheduleFromDb.getDateOfPay(), is(LocalDate.now()));
        MatcherAssert.assertThat(paymentScheduleFromDb.getMonthlyPayment(), is("9808,17"));
    }

    @Test
    public void deletePaymentSchedule(){
        PaymentSchedule paymentScheduleFromDb = repository.save(paymentSchedule);
        Assertions.assertDoesNotThrow(() -> repository.deleteById(paymentScheduleFromDb.getId()));
    }
}