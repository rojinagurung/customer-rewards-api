package com.retail.rewards.customerrewardsapi.controller;

import com.retail.rewards.customerrewardsapi.dao.Customer;
import com.retail.rewards.customerrewardsapi.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CustomerControllerTest {
    @MockBean
    private CustomerService customerService;
    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    int randomServerPort;

    @Test
    void testGetCustomerById() {
        Customer customer = new Customer();
        customer.setCustomerId(1L);
        Mockito.when(customerService.getCustomerById(1L)).thenReturn(customer);
        ResponseEntity<Customer> responseEntity = this.restTemplate.getForEntity("http://localhost:" + randomServerPort + "/v1/api/customer/1", Customer.class);
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(customer, responseEntity.getBody());
    }

    @Test
    void testGetAllCustomers() {
        Customer customer = new Customer();
        customer.setCustomerId(1L);
        Customer customer2 = new Customer();
        customer2.setCustomerId(2L);
        Mockito.when(customerService.getAllCustomers()).thenReturn(List.of(customer, customer2));
        ResponseEntity<List> responseEntity = this.restTemplate.getForEntity("http://localhost:" + randomServerPort + "/v1/api/customer", List.class);
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(2, responseEntity.getBody().size());
    }

    @Test
    void testAddCustomer() {
        Customer customer = new Customer();
        customer.setCustomerId(1L);
        Mockito.when(customerService.addCustomer(customer)).thenReturn(customer);
        HttpEntity<Customer> httpEntity = new HttpEntity<>(customer);
        ResponseEntity<Customer> responseEntity = this.restTemplate.postForEntity("http://localhost:" + randomServerPort + "/v1/api/customer", httpEntity, Customer.class);
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(customer, responseEntity.getBody());

    }
}