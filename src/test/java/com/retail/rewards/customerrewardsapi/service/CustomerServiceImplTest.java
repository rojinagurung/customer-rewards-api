package com.retail.rewards.customerrewardsapi.service;

import com.retail.rewards.customerrewardsapi.dao.Customer;
import com.retail.rewards.customerrewardsapi.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {

    @Mock
    private CustomerRepository customerRepository;
    @InjectMocks
    CustomerServiceImpl customerService;

    @Test
    void testGetCustomerById() {
        Customer customer = new Customer();
        customer.setCustomerId(1L);
        customer.setCustomerName("Foo Bar");
        Mockito.when(customerRepository.findById(1L)).thenReturn(Optional.of(customer));
        Customer actualCustomer = customerService.getCustomerById(1L);
        assertNotNull(actualCustomer);
        assertEquals(1L, actualCustomer.getCustomerId());
        assertEquals("Foo Bar", actualCustomer.getCustomerName());
    }

    @Test
    void testGetAllCustomer() {
        Customer customer = new Customer();
        customer.setCustomerId(1L);
        customer.setCustomerName("Foo Bar");
        Customer customer2 = new Customer();
        customer2.setCustomerId(2L);
        customer2.setCustomerName("Foo2 Bar2");
        Mockito.when(customerRepository.findAll()).thenReturn(List.of(customer, customer2));
        List<Customer> customers = customerService.getAllCustomers();
        assertNotNull(customers);
        assertEquals(2, customers.size());
    }

    @Test
    void testAddCustomer() {
        Customer customer = new Customer();
        customer.setCustomerId(1L);
        customer.setCustomerName("Foo Bar");
        Mockito.when(customerRepository.save(any())).thenReturn(customer);
        Customer actualCustomer = customerService.addCustomer(customer);
        assertNotNull(actualCustomer);
        assertEquals(1L, actualCustomer.getCustomerId());
        assertEquals("Foo Bar", actualCustomer.getCustomerName());
    }

}