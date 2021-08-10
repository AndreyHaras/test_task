package com.haulmont.test_task.dao.repository;

import com.haulmont.test_task.dao.entity.LoanOffer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.List;
import java.util.UUID;
import static org.hamcrest.core.Is.is;

@DataJpaTest
class LoanOfferRepositoryTest extends Activeprofile {

    @Autowired
    private LoanOfferRepository repository;
    private static final Logger logger = LogManager.getLogger("LoanOfferRepositoryTest");
    private static LoanOffer loanOffer;

    @BeforeAll
    public static void setup() {
        LoanOffer newLoanOffer = new LoanOffer();
        newLoanOffer.setCreditAmount("350000");
        newLoanOffer.setCreditId(UUID.fromString("8aa3defc-4f82-4402-b0f9-43cf2123270b"));
        newLoanOffer.setCustomerId(UUID.fromString("3214a019-9502-4f89-9908-fd30fba46b96"));
        loanOffer = newLoanOffer;
    }

    @Test
    public void findAllRecord(){
        List<LoanOffer> loanOffers = repository.findAll();
        for (LoanOffer loanOffer : loanOffers){
            logger.info("find all loan offer : " + loanOffer.getCredit().getCreditLimit() + " " + loanOffer.getCustomer().getFullyQualifiedName());
        }
        MatcherAssert.assertThat(loanOffers.size(), is(2));
    }

    @Test
    public void saveNewLoanOffer(){
        LoanOffer loanOfferFromDb = repository.save(loanOffer);
        logger.info("save new loan offer in db : " + loanOfferFromDb.getCreditId() + " " + loanOfferFromDb.getCreditId());
        MatcherAssert.assertThat(loanOfferFromDb.getCreditId(), is(UUID.fromString("8aa3defc-4f82-4402-b0f9-43cf2123270b")));
        MatcherAssert.assertThat(loanOfferFromDb.getCustomerId(), is(UUID.fromString("3214a019-9502-4f89-9908-fd30fba46b96")));
    }

    @Test
    public void deleteLoanOffer(){
        LoanOffer loanOfferFromDb = repository.save(loanOffer);
        Assertions.assertDoesNotThrow(() -> repository.deleteById(loanOfferFromDb.getId()));
    }
}