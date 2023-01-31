package com.retail.rewards.customerrewardsapi.service;


import com.retail.rewards.customerrewardsapi.dao.Customer;

public interface CustomerService {
    Customer getCustomerById(Long id);
    Customer addCustomer(Customer  customer);
}
