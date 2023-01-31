package com.retail.rewards.customerrewardsapi.util;

import com.retail.rewards.customerrewardsapi.dao.Transaction;

import java.time.Month;
import java.util.List;

public class RewardsUtil {

    public static int calculateTotalForMonth(List<Transaction> transactions, Month month) {
        return transactions
                .stream()
                .filter(transaction -> month.equals(transaction.getTransactionDate().getMonth()))
                .map(Transaction::getTransactionAmount)
                .map(RewardsUtil::calculateRewardsPerTransactionAmount)
                .reduce(0, Integer::sum);
    }

    public static int calculateTotalRewards(List<Transaction> transactions) {
        return transactions
                .stream()
                .map(Transaction::getTransactionAmount)
                .map(RewardsUtil::calculateRewardsPerTransactionAmount)
                .reduce(0, Integer::sum);
    }

    public static int calculateRewardsPerTransactionAmount(double transactionAmount) {
        int rewardPoint = 0;
        if (transactionAmount > 100) {
            rewardPoint = (int) ((((transactionAmount - 100) * 2) + 50));
        } else if (transactionAmount > 50 && transactionAmount < 100) {
            rewardPoint = (int) (transactionAmount - 50);
        }
        return rewardPoint;
    }
}
