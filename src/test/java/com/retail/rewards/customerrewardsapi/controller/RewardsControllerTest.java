package com.retail.rewards.customerrewardsapi.controller;

import com.retail.rewards.customerrewardsapi.TestConstants;
import com.retail.rewards.customerrewardsapi.dao.Customer;
import com.retail.rewards.customerrewardsapi.service.CustomerRewardsService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RewardsControllerTest {
    @MockBean
    private CustomerRewardsService customerRewardsService;
    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    int randomServerPort;

    @Test
    void testMonthlyRewardsPoint() {
        Customer customer = new Customer();
        customer.setCustomerId(1L);
        customer.setTransactions(TestConstants.getTransactionList());
        Mockito.when(customerRewardsService.getPointsPerMonth(1L, "01")).thenReturn(60);
        ResponseEntity<Map> responseEntity = this.restTemplate.getForEntity("http://localhost:" + randomServerPort + "/v1/api/reward/customer/1/month/01", Map.class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Map responseMap = responseEntity.getBody();
        assertNotNull(responseMap);
        assertEquals(1, responseMap.get("customerId"));
        assertEquals("JANUARY", responseMap.get("month"));
        assertEquals(60, responseMap.get("monthlyRewards"));
    }

    @Test
    void testGetMonthlyReport() {
        Map<String, Object> reportMap = new HashMap<>();
        reportMap.put("customerId", 2L);
        reportMap.put("JANUARY", 60);
        Mockito.when(customerRewardsService.getMonthlyReport(2L)).thenReturn(reportMap);
        ResponseEntity<Map> responseEntity = this.restTemplate.getForEntity("http://localhost:" + randomServerPort + "/v1/api/reward/customer/2/monthlyReport", Map.class);
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Map responseMap = responseEntity.getBody();
        assertEquals(2, responseMap.get("customerId"));
        assertEquals(60, responseMap.get("JANUARY"));
    }
    @Test
    void testGetTotalRewardPoint() {
        Map<String, Object> reportMap = new HashMap<>();
        reportMap.put("customerId", 3L);
        reportMap.put("totalRewardsEarned", 100);
        Mockito.when(customerRewardsService.getTotalPoints(3L)).thenReturn(100);
        ResponseEntity<Map> responseEntity = this.restTemplate.getForEntity("http://localhost:" + randomServerPort + "/v1/api/reward/customer/3/totalPoints", Map.class);
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Map responseMap = responseEntity.getBody();
        assertEquals(3, responseMap.get("customerId"));
        assertEquals(100, responseMap.get("totalRewardsEarned"));
    }
}