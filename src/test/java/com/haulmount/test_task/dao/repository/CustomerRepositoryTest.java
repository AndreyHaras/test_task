package com.haulmount.test_task.dao.repository;

import com.haulmount.test_task.dao.entity.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.List;

@DataJpaTest
class CustomerRepositoryTest extends Activeprofile {
    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void fundAllTestConnection(){
        List<Customer> customers = customerRepository.findAll();
        for(Customer customer : customers){
            System.out.println(customer.getFullyQualifiedName());
        }
    }
}