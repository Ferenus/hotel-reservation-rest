package com.danielstradowski.persistence.dao;

import com.danielstradowski.persistence.model.Customer;

public interface CustomerDao {

    void create(Customer customer);

    Customer getCustomerById(String id);
}
