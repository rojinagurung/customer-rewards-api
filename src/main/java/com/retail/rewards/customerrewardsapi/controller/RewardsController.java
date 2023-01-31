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
    private CustomerRewardsService customerRewardsService;

    public RewardsController(CustomerRewardsService customerRewardsService) {
        this.customerRewardsService = customerRewardsService;
    }

    @GetMapping("/customer/{customerId}/month/{monthNumeral}")
    public Map<String, Object> monthlyRewardsPoint(@PathVariable("customerId") Long customerId, @PathVariable("monthNumeral") String month) {
        Map<String, Object> responseMap = new LinkedHashMap<>();
        responseMap.put("customerId", customerId);
        responseMap.put("mont", Month.of(Integer.parseInt(month)));
        responseMap.put("monthlyRewards", customerRewardsService.getPointsPerMonth(customerId, month));
        return responseMap;
    }

    @GetMapping("/customer/{customerId}/monthlyReport")
    public Map<String, Object> getMonthlyReport(@PathVariable("customerId") Long customerId) {
        return customerRewardsService.getMonthlyReport(customerId);

    }

    @GetMapping("/customer/{id}/totalPoints")
    public Map<String, Object> totalRewardsPoint(@PathVariable("id") Long customerId) {
        Map<String, Object> responseMap = new LinkedHashMap<>();
        responseMap.put("customerId", customerId);
        responseMap.put("totalRewardsEarned", customerRewardsService.getTotalPoints(customerId));
        return responseMap;
    }
}
