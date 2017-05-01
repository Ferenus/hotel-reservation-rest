package com.danielstradowski.rest.controller;

import com.danielstradowski.rest.entity.CustomerDTO;
import com.danielstradowski.rest.service.CustomerService;
import com.danielstradowski.rest.util.CustomErrorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    public static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<?> registerNewRoom(@RequestBody CustomerDTO customer) {
        logger.info("Creating customer : {}", customer);

        if (customerService.isCustomerExists(customer)) {
            logger.error("Customer with firstname {} and lastname {} already exists.", customer.getFirstName(), customer.getLastName());
            return new ResponseEntity<>(new CustomErrorType("Customer with firstname " +
                    customer.getFirstName() + " and lastname " + customer.getLastName() + " already exists."), HttpStatus.CONFLICT);
        }
        customerService.saveCustomer(customer);

        return new ResponseEntity<CustomerDTO>(HttpStatus.CREATED);
    }
}
