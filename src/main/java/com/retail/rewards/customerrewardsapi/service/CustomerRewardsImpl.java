package com.retail.rewards.customerrewardsapi.service;

import com.retail.rewards.customerrewardsapi.dao.Customer;
import com.retail.rewards.customerrewardsapi.dao.Transaction;
import com.retail.rewards.customerrewardsapi.util.RewardsUtil;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomerRewardsImpl implements CustomerRewardsService {
    private static final String CUSTOMER_ID_KEY = "customerId";
    private final CustomerService customerService;

    public CustomerRewardsImpl(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public int getPointsPerMonth(Long customerId, String month) {
        return RewardsUtil
                .calculateTotalForMonth(getTransactionsForCustomer(customerId), Month.of(Integer.parseInt(month)));
    }

    private Customer getCustomer(Long customerId) {
        return customerService.getCustomerById(customerId);
    }

    @Override
    public Integer getTotalPoints(Long customerId) {
        return RewardsUtil
                .calculateTotalRewards(getTransactionsForCustomer(customerId));
    }

    @Override
    public Map<String, Object> getMonthlyReport(Long customerId) {
        List<Transaction> transactions = getTransactionsForCustomer(customerId);
        Map<String, Object> returnValue = new LinkedHashMap<>();
        returnValue.put(CUSTOMER_ID_KEY, customerId);
        Set<Month> monthSet = transactions.stream().map(transaction -> transaction.getTransactionDate().getMonth()).collect(Collectors.toSet());
        monthSet.forEach(month -> returnValue.put(month.toString(), RewardsUtil.calculateTotalForMonth(transactions, month)));
        return returnValue;
    }

    private List<Transaction> getTransactionsForCustomer(Long customerId) {
        return getCustomer(customerId).getTransactions();
    }
}
