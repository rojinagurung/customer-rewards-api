package com.retail.rewards.customerrewardsapi.controller;

import com.retail.rewards.customerrewardsapi.TestConstants;
import com.retail.rewards.customerrewardsapi.dao.Customer;
import com.retail.rewards.customerrewardsapi.dao.Transaction;
import com.retail.rewards.customerrewardsapi.service.CustomerService;
import com.retail.rewards.customerrewardsapi.service.TransactionService;
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

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TransactionControllerTest {
    @MockBean
    private TransactionService transactionService;
    @MockBean
    private CustomerService customerService;
    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    int randomServerPort;

    @Test
    void testGetCustomerTransactions() {
        Customer customer = new Customer();
        customer.setCustomerId(1L);
        customer.setTransactions(TestConstants.getTransactionList());
        Mockito.when(customerService.getCustomerById(1L)).thenReturn(customer);
        ResponseEntity<List> responseEntity = this.restTemplate.getForEntity("http://localhost:" + randomServerPort + "/v1/api/transaction/customer/1", List.class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        List<Transaction> transactions = responseEntity.getBody();
        assertNotNull(transactions);
        assertEquals(4, transactions.size());
    }


    @Test
    void testSaveCustomerTransaction() {
        Customer customer = new Customer();
        customer.setCustomerId(1L);
        Transaction transaction = new Transaction();
        transaction.setTransactionAmount(80);
        transaction.setTransactionDate(LocalDate.of(2022, 01, 03));
        transaction.setCustomer(customer);
        Mockito.when(customerService.getCustomerById(1L)).thenReturn(customer);
        Mockito.when(transactionService.saveTransaction(any())).thenReturn(transaction);
        HttpEntity<Transaction> entity = new HttpEntity<>(transaction);
        ResponseEntity<Transaction> responseEntity = this.restTemplate.postForEntity("http://localhost:" + randomServerPort + "/v1/api/transaction/customer/1", entity, Transaction.class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(transaction, responseEntity.getBody());
    }


}