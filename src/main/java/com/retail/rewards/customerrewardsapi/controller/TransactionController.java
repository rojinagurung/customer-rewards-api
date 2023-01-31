package com.retail.rewards.customerrewardsapi.controller;

import com.retail.rewards.customerrewardsapi.dao.Customer;
import com.retail.rewards.customerrewardsapi.dao.Transaction;
import com.retail.rewards.customerrewardsapi.service.CustomerService;
import com.retail.rewards.customerrewardsapi.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/api/transaction")
public class TransactionController {
    private TransactionService transactionService;
    private CustomerService customerService;

    @Autowired
    public TransactionController(CustomerService customerService, TransactionService transactionService) {
        this.customerService = customerService;
        this.transactionService = transactionService;
    }


    @PostMapping("/customer/{id}")
    public Transaction saveCustomerTransaction(@RequestBody Transaction transaction, @PathVariable("id") Long customerId) {
        Customer customer = customerService.getCustomerById(customerId);
        transaction.setCustomer(customer);
        return transactionService.saveTransaction(transaction);
    }

    @GetMapping("/customer/{id}")
    public List<Transaction> getCustomerTransactions(@PathVariable("id") Long customerId) {
        Customer customer = customerService.getCustomerById(customerId);
        List<Transaction> transactions = new ArrayList<>();
        customer.getTransactions().forEach(x -> transactions.add(transactionService.getTransactionByTransactionId(x.getTransactionId())));
        return transactions;
    }


}
