package com.haulmont.test_task.dao.repository;

import com.haulmont.test_task.dao.entity.Credit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.hamcrest.core.Is.is;
import java.util.List;

@DataJpaTest
class CreditRepositoryTest extends Activeprofile {

    @Autowired
    private CreditRepository creditRepository;
    private static final Logger logger = LogManager.getLogger("CreditRepositoryTest");
    private static Credit credit;

    @BeforeAll
    public static void setup() {
        Credit newCredit = new Credit();
        newCredit.setCreditLimit("1000000");
        newCredit.setInterestRate("15.75");
        credit = newCredit;
    }

    @Test
    public void findAllRecords(){
        List<Credit> credits = creditRepository.findAll();
        for (Credit credit : credits){
            logger.info("find all credits : " + credit.getInterestRate() + " " + credit.getCreditLimit());
        }
        MatcherAssert.assertThat(credits.size(), is(4));
    }

    @Test
    public void saveNewCredit(){
        Credit newCredit = creditRepository.save(credit);
        logger.info("save new credit in db : " + newCredit.getCreditLimit() + " " + newCredit.getInterestRate());
        MatcherAssert.assertThat(newCredit.getCreditLimit(), is("1000000"));
        MatcherAssert.assertThat(newCredit.getInterestRate(), is("15.75"));
    }

    @Test
    public void findById(){
        Credit newCredit = creditRepository.save(credit);
        Credit creditTestFind = creditRepository.findById(newCredit.getId()).get();
        logger.info("find by id : " + creditTestFind.getId());
        MatcherAssert.assertThat(creditTestFind.getInterestRate(), is("15.75"));
        MatcherAssert.assertThat(creditTestFind.getCreditLimit(), is("1000000"));
    }

    @Test
    public void deleteCredit(){
        Credit newCredit = creditRepository.save(credit);
        Assertions.assertDoesNotThrow(() -> creditRepository.deleteById(newCredit.getId()));
    }
}