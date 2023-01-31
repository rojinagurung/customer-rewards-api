package com.retail.rewards.customerrewardsapi.util;

import com.retail.rewards.customerrewardsapi.dao.Transaction;

import java.util.List;

public class RewardsUtil {
    public static int calculateTotalPoints(List<Transaction> transactions) {
//        return transactions.
        return 0;
    }

    public static int calculateMonthlyRewards(List<Transaction> transactions) {
        return transactions
                .stream()
                .map(transaction -> calculateRewardsPerTransactionAmount(transaction.getTransactionAmount()))
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
