package com.haulmount.test_task.service;

import com.haulmount.test_task.service.dto.CustomerDTO;
import java.util.List;

public interface CustomerService  {

    List<CustomerDTO> findAll();
    void save(CustomerDTO customer);
    void delete(CustomerDTO customer);
}
