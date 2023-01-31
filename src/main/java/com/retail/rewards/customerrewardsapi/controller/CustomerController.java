package com.retail.rewards.customerrewardsapi.controller;

import com.retail.rewards.customerrewardsapi.dao.Customer;
import com.retail.rewards.customerrewardsapi.service.CustomerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/customer")
public class CustomerController {
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable("id") Long customerId) {
        return customerService.getCustomerById(customerId);
    }

    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }
}