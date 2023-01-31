package com.retail.rewards.customerrewardsapi.service;

import java.util.Map;

public interface CustomerRewardsService {
    int getPointsPerMonth(Long customerId, String month);
    Long getTotalPoints(Long customerId);
    Map<String, Object> getMonthlyReport(Long customerId);
}
