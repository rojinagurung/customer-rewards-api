package com.retail.rewards.customerrewardsapi.util;

import com.retail.rewards.customerrewardsapi.TestConstants;
import com.retail.rewards.customerrewardsapi.dao.Transaction;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Month;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class RewardsUtilTest {
    @Test
    void calculateTotalAmountForAMonthWhenMultipleMonthWithRewards() {
        List<Transaction> transactions = TestConstants.getTransactionList();
        int rewardsAmountForJanuary = RewardsUtil.calculateTotalForMonth(transactions, Month.JANUARY);
        int rewardsAmountForFebruary = RewardsUtil.calculateTotalForMonth(transactions, Month.FEBRUARY);
        assertEquals(60, rewardsAmountForJanuary);
        assertEquals(0, rewardsAmountForFebruary);
    }

    @Test
    void testTotalRewards() {
        List<Transaction> transactions = TestConstants.getTransactionList();
        int totalRewards = RewardsUtil.calculateTotalRewards(transactions);
        assertEquals(150, totalRewards);
    }

    @Test
    void testRewardsPerTransaction() {
        int noRewards = RewardsUtil.calculateRewardsPerTransactionAmount(40.0);
        int singularRewards = RewardsUtil.calculateRewardsPerTransactionAmount(60.0);
        int bonusRewards = RewardsUtil.calculateRewardsPerTransactionAmount(130.0);
        assertEquals(0, noRewards);
        assertEquals(10, singularRewards);
        assertEquals(110, bonusRewards);


    }

}