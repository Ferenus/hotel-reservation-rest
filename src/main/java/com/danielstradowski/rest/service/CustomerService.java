package com.danielstradowski.rest.service;

import com.danielstradowski.rest.entity.CustomerDTO;

public interface CustomerService {

    void saveCustomer(CustomerDTO customerDTO);

    boolean isCustomerExists(CustomerDTO customerDTO);
}
