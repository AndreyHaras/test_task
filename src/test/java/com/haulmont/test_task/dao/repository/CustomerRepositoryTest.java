package com.haulmont.test_task.dao.repository;

import com.haulmont.test_task.dao.entity.Customer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.List;
import static org.hamcrest.core.Is.is;

@DataJpaTest
class CustomerRepositoryTest extends Activeprofile {
    @Autowired
    private CustomerRepository customerRepository;

    private static final Logger logger = LogManager.getLogger("CustomerRepositoryTest");
    private static Customer customer;

    @BeforeAll
    public static void setup() {
        Customer newCustomer = new Customer();
        newCustomer.setEmail("IvanovAlex@mail.com");
        newCustomer.setFullyQualifiedName("Крюкова Ольга Петровна");
        newCustomer.setPassportNumber("4445140932");
        newCustomer.setPhoneNumber("89269389520");
        customer = newCustomer;
    }

    @Test
    public void fundAllRecordTestConnection(){
        List<Customer> customers = customerRepository.findAll();
        for(Customer customer : customers){
            logger.info("fundAllRecordTest : " + customer.getFullyQualifiedName() + " " + customer.getEmail());
        }
        MatcherAssert.assertThat(customers.size(), is(6));
    }

    @Test
    public void saveCustomerToDb(){
        Customer newCustomer = customerRepository.save(customer);
        logger.info("saveCustomerToDb :" + newCustomer.getFullyQualifiedName());
        MatcherAssert.assertThat(newCustomer.getFullyQualifiedName(), is("Крюкова Ольга Петровна"));
        MatcherAssert.assertThat(newCustomer.getEmail(), is("IvanovAlex@mail.com"));
    }

    @Test
    public void findById(){
        Customer newCustomer = customerRepository.save(customer);
        Customer customerTestFind = customerRepository.getById(newCustomer.getId());
        logger.info("Save customer :" + newCustomer.getFullyQualifiedName());
        logger.info("find By Id customer :" + customerTestFind.getFullyQualifiedName());
        MatcherAssert.assertThat(customerTestFind.getId(), is(newCustomer.getId()));
    }
}