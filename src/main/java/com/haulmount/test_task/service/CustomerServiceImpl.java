package com.haulmount.test_task.service;

import com.haulmount.test_task.dao.entity.Customer;
import com.haulmount.test_task.dao.repository.CustomerRepository;
import com.haulmount.test_task.service.dto.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository repository;

    @Autowired
    public void setRepository(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean checkCustomerOnCredit(UUID customerId) {
        Optional<Customer> customerCheckOnCredit = repository.findById(customerId);
        return customerCheckOnCredit.get().getBank() != null;
    }

    @Override
    public CustomerDTO findById(UUID customerId) {
        return findCustomer(repository.findById(customerId));
    }

    @Override
    public List<CustomerDTO> findAll() {
        return createCustomerList(repository.findAll());
    }

    @Override
    public Customer save(CustomerDTO customer) {
        return repository.save(customerToDb(customer));
    }

    @Override
    public void delete(UUID customerId) {
        repository.deleteById(customerId);
    }

    private CustomerDTO findCustomer(Optional<Customer> customerFromDb){
        Customer customer = customerFromDb.get();
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customer.getId());
        customerDTO.setFullyQualifiedName(customer.getFullyQualifiedName());
        customerDTO.setPhoneNumber(customer.getPhoneNumber());
        customerDTO.setPassportNumber(customer.getPassportNumber());
        customerDTO.setEmail(customer.getEmail());
        return customerDTO;
    }

    private List<CustomerDTO> createCustomerList(List<Customer> customers){
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
}
