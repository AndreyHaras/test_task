package com.haulmount.test_task.service;

import com.haulmount.test_task.dao.entity.Customer;
import com.haulmount.test_task.dao.repository.CustomerRepository;
import com.haulmount.test_task.service.dto.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository repository;

    @Autowired
    public void setRepository(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<CustomerDTO> findAll() {
        return createCustomersList(repository.findAll());
    }

    @Override
    public void save(CustomerDTO customer) {
        repository.save(customerToDb(customer));
    }

    @Override
    public void delete(CustomerDTO customer) {
        repository.delete(customerToDelete(customer));
    }

    private List<CustomerDTO> createCustomersList(List<Customer> customers){
        List<CustomerDTO> result = new ArrayList<>();
        for (Customer customer : customers){
            CustomerDTO newCustomer = new CustomerDTO();
            newCustomer.setFullyQualifiedName(customer.getFullyQualifiedName());
            newCustomer.setEmail(customer.getEmail());
            newCustomer.setPassportNumber(customer.getPassportNumber());
            newCustomer.setPhoneNumber(customer.getPhoneNumber());
            newCustomer.setId(customer.getId());
            result.add(newCustomer);
        }
        return result;
    }

    private Customer customerToDb(CustomerDTO customer){
        Customer customerToDb = new Customer();
        customerToDb.setFullyQualifiedName(customer.getFullyQualifiedName());
        customerToDb.setPhoneNumber(customer.getPhoneNumber());
        customerToDb.setPassportNumber(customer.getPassportNumber());
        customerToDb.setEmail(customer.getEmail());
        return customerToDb;
    }

    private Customer customerToDelete(CustomerDTO customer){
        Customer customerToDelete = new Customer();
        customerToDelete.setFullyQualifiedName(customer.getFullyQualifiedName());
        customerToDelete.setPhoneNumber(customer.getPhoneNumber());
        customerToDelete.setPassportNumber(customer.getPassportNumber());
        customerToDelete.setEmail(customer.getEmail());
        customerToDelete.setId(customer.getId());
        return customerToDelete;
    }
}
