package com.retail.rewards.customerrewardsapi.service;

import com.retail.rewards.customerrewardsapi.dao.Transaction;
import com.retail.rewards.customerrewardsapi.repository.TransactionRepository;
import com.retail.rewards.customerrewardsapi.util.RewardsUtil;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {
    TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override

    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public Transaction getTransactionByTransactionId(Long id) {
        return transactionRepository.findById(id).orElse(null);
    }
}
