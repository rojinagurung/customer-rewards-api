package com.retail.rewards.customerrewardsapi;

import com.retail.rewards.customerrewardsapi.dao.Customer;
import com.retail.rewards.customerrewardsapi.dao.Transaction;

import java.time.LocalDate;
import java.util.List;

public class TestConstants {
    public static List<Transaction> getTransactionList() {
        Customer customer = new Customer();
        customer.setCustomerId(1L);
        Transaction transaction = new Transaction();
        transaction.setTransactionAmount(80);
        transaction.setTransactionDate(LocalDate.of(2022, 01, 03));
        transaction.setCustomer(customer);
        Transaction transaction2 = new Transaction();
        transaction2.setTransactionAmount(80);
        transaction2.setTransactionDate(LocalDate.of(2022, 01, 04));
        transaction2.setCustomer(customer);
        Transaction transaction3 = new Transaction();
        transaction3.setTransactionAmount(40);
        transaction3.setTransactionDate(LocalDate.of(2022, 02, 04));
        transaction3.setCustomer(customer);
        Transaction transaction4 = new Transaction();
        transaction4.setTransactionAmount(120);
        transaction4.setTransactionDate(LocalDate.of(2022, 03, 04));
        transaction4.setCustomer(customer);
        return List.of(transaction, transaction2, transaction3, transaction4);
    }
}
