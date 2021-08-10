package com.haulmont.test_task.dao.repository;

import com.haulmont.test_task.dao.entity.Bank;
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
import java.util.UUID;

@DataJpaTest
class BankRepositoryTest extends Activeprofile {

    @Autowired
    private BankRepository repository;

    private static final Logger logger = LogManager.getLogger("BankRepositoryTest");
    private static Bank bank;

    @BeforeAll
    public static void setup() {
        Bank newBank = new Bank();
        newBank.setCustomerId(UUID.fromString("14878326-b111-42bf-a553-f74dd0bc0fa3"));
        newBank.setCreditId(UUID.fromString("8aa3defc-4f82-4402-b0f9-43cf2123270b"));
        bank = newBank;
    }

    @Test
    public void findAllRecord(){
        List<Bank> banks = repository.findAll();
        for(Bank bank : banks){
            logger.info("find all bank : " + bank.getCredit().getCreditLimit() + " " + bank.getCustomer().getFullyQualifiedName());
        }
        MatcherAssert.assertThat(banks.size(), is(2));
    }

    @Test
    public void saveNewBankRecord(){
        Bank newBank = repository.save(bank);
        logger.info("save new bank in db : " + newBank.getCreditId() + " " + newBank.getCreditId());
        MatcherAssert.assertThat(newBank.getCreditId(), is(UUID.fromString("8aa3defc-4f82-4402-b0f9-43cf2123270b")));
        MatcherAssert.assertThat(newBank.getCustomerId(), is(UUID.fromString("14878326-b111-42bf-a553-f74dd0bc0fa3")));
    }

    @Test
    public void deleteRecordFromBank(){
        Bank newBank = repository.save(bank);
        Assertions.assertDoesNotThrow(() -> repository.deleteById(newBank.getId()));
    }
}