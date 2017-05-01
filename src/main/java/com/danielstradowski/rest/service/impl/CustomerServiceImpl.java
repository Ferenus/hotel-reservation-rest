package com.danielstradowski.rest.service.impl;

import com.danielstradowski.rest.entity.CustomerDTO;
import com.danielstradowski.rest.service.CustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Override
    public void saveCustomer(CustomerDTO customerDTO) {

    }

    @Override
    public boolean isCustomerExists(CustomerDTO customerDTO) {
        return false;
    }
}
