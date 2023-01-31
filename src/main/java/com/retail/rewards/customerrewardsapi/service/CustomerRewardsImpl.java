package com.retail.rewards.customerrewardsapi.service;

import com.retail.rewards.customerrewardsapi.dao.Customer;
import com.retail.rewards.customerrewardsapi.dao.Transaction;
import com.retail.rewards.customerrewardsapi.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomerRewardsImpl implements CustomerRewardsService {
    private final TransactionRepository transactionRepository;
    private final CustomerService customerService;

    public CustomerRewardsImpl(TransactionRepository transactionRepository, CustomerService customerService) {
        this.transactionRepository = transactionRepository;
        this.customerService = customerService;
    }

    @Override
    public int getPointsPerMonth(Long customerId, String month) {
        return calculateTotalForMonth(getTransactionsForCustomer(customerId), Month.of(Integer.parseInt(month)));
    }

    private List<Transaction> getTransactionsForCustomer(Long customerId) {
        return getCustomer(customerId).getTransactions();
    }

    private int calculateTotalForMonth(List<Transaction> transactions, Month month) {
        return transactions
                .stream()
                .filter(transaction -> month.equals(transaction.getTransactionDate().getMonth()))
                .map(Transaction::getTransactionRewards)
                .reduce(0, Integer::sum);
    }

    private Customer getCustomer(Long customerId) {
        return customerService.getCustomerById(customerId);
    }

    @Override
    public Long getTotalPoints(Long customerId) {
        return transactionRepository.getTotalRewardPointForCustomer(customerId);
    }

    @Override
    public Map<String, Object> getMonthlyReport(Long customerId) {
        List<Transaction> transactions = getTransactionsForCustomer(customerId);
        Map<String, Object> returnValue = new LinkedHashMap<>();
        returnValue.put("customerId", customerId);
        Set<Month> monthSet = transactions.stream().map(transaction -> transaction.getTransactionDate().getMonth()).collect(Collectors.toSet());
        monthSet.forEach(month -> returnValue.put(month.toString(), calculateTotalForMonth(transactions, month)));
        return returnValue;
    }

}
