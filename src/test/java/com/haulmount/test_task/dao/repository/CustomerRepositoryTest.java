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
    @Test
    public void isSave(){
        Customer customer = new Customer();
        customer.setEmail("IvanovAlex@mail.com");
        customer.setFullyQualifiedName("Крюкова Ольга Петровна");
        customer.setPassportNumber("4445140932");
        customer.setPhoneNumber("89269389520");
        Customer newCustomer = customerRepository.save(customer);
        System.out.println(newCustomer.getId());
        System.out.println(customerRepository.findAll().size());
    }
}