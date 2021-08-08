package com.haulmount.test_task.service;

import com.haulmount.test_task.dao.entity.Customer;
import com.haulmount.test_task.service.dto.CustomerDTO;
import java.util.List;
import java.util.UUID;

public interface CustomerService  {

    boolean checkCustomerOnCredit(UUID customerId);
    List<CustomerDTO> findAll();
    Customer save(CustomerDTO customer);
    void delete(UUID customerId);
}
