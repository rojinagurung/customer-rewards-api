package com.retail.rewards.customerrewardsapi.service;

import com.retail.rewards.customerrewardsapi.dao.Transaction;

public interface TransactionService {
    Transaction saveTransaction(Transaction transaction);

    Transaction getTransactionByTransactionId(Long id);
}
