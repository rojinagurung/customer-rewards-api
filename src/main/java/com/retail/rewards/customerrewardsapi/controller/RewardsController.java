package com.retail.rewards.customerrewardsapi.controller;

import com.retail.rewards.customerrewardsapi.service.CustomerRewardsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Month;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/api/reward")
public class RewardsController {
    private static final String CUSTOMER_ID_KEY = "customerId";
    private static final String MONTH_KEY = "month";
    private static final String MONTHLY_REWARDS_KEY = "monthlyRewards";
    private static final String TOTAL_REWARDS_EARNED_KEY = "totalRewardsEarned";
    private CustomerRewardsService customerRewardsService;

    public RewardsController(CustomerRewardsService customerRewardsService) {
        this.customerRewardsService = customerRewardsService;
    }

    @GetMapping("/customer/{customerId}/month/{monthNumeral}")
    public Map<String, Object> monthlyRewardsPoint(@PathVariable(CUSTOMER_ID_KEY) Long customerId, @PathVariable("monthNumeral") String month) {
        Map<String, Object> responseMap = new LinkedHashMap<>();
        responseMap.put(CUSTOMER_ID_KEY, customerId);
        responseMap.put(MONTH_KEY, Month.of(Integer.parseInt(month)));
        responseMap.put(MONTHLY_REWARDS_KEY, customerRewardsService.getPointsPerMonth(customerId, month));
        return responseMap;
    }

    @GetMapping("/customer/{customerId}/monthlyReport")
    public Map<String, Object> getMonthlyReport(@PathVariable(CUSTOMER_ID_KEY) Long customerId) {
        return customerRewardsService.getMonthlyReport(customerId);

    }

    @GetMapping("/customer/{id}/totalPoints")
    public Map<String, Object> totalRewardsPoint(@PathVariable("id") Long customerId) {
        Map<String, Object> responseMap = new LinkedHashMap<>();
        responseMap.put(CUSTOMER_ID_KEY, customerId);
        responseMap.put(TOTAL_REWARDS_EARNED_KEY, customerRewardsService.getTotalPoints(customerId));
        return responseMap;
    }
}
