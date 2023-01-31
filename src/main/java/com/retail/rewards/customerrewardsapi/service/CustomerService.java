package com.retail.rewards.customerrewardsapi.service;


import com.retail.rewards.customerrewardsapi.dao.Customer;

import java.util.List;

public interface CustomerService {
    Customer getCustomerById(Long id);
    Customer addCustomer(Customer  customer);
    List<Customer> getAllCustomers();
}
