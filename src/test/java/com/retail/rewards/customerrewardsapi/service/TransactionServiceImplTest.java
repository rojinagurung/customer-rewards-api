package com.retail.rewards.customerrewardsapi.service;

import com.retail.rewards.customerrewardsapi.dao.Transaction;
import com.retail.rewards.customerrewardsapi.repository.TransactionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class TransactionServiceImplTest {
    @Mock
    TransactionRepository transactionRepositoryMock;
    @InjectMocks
    TransactionServiceImpl transactionService;

    @Test
    void testSaveTransaction() {
        Transaction transaction = new Transaction();
        transaction.setTransactionAmount(120);
        transaction.setTransactionId(9001L);
        Mockito.when(transactionRepositoryMock.save(any())).thenReturn(transaction);
        Transaction actualTransaction = transactionService.saveTransaction(transaction);
        assertNotNull(actualTransaction);
        assertEquals(120, actualTransaction.getTransactionAmount());
        assertEquals(9001L, actualTransaction.getTransactionId());
    }

    @Test
    void testGetTransactionById() {
        Transaction transaction = new Transaction();
        transaction.setTransactionAmount(120);
        transaction.setTransactionId(9001L);
        Mockito.when(transactionRepositoryMock.findById(9001L)).thenReturn(Optional.of(transaction));
        Transaction actualTransaction = transactionService.getTransactionByTransactionId(9001L);
        assertNotNull(actualTransaction);
        assertEquals(120, actualTransaction.getTransactionAmount());
        assertEquals(9001L, actualTransaction.getTransactionId());
    }

}