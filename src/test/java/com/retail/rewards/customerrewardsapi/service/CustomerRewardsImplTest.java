package com.retail.rewards.customerrewardsapi.service;

import com.retail.rewards.customerrewardsapi.TestConstants;
import com.retail.rewards.customerrewardsapi.dao.Customer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class CustomerRewardsImplTest {
    @Mock
    private CustomerServiceImpl customerService;
    @InjectMocks
    private CustomerRewardsImpl customerRewards;

    @Test
    void testGetPointsPerMonth() {
        Customer customer = new Customer();
        customer.setCustomerId(1L);
        customer.setTransactions(TestConstants.getTransactionList());
        Mockito.when(customerService.getCustomerById(1L)).thenReturn(customer);
        int rewards = customerRewards.getPointsPerMonth(1L, "01");
        assertEquals(60, rewards);
    }

    @Test
    void testGetTotalRewards() {
        Customer customer = new Customer();
        customer.setCustomerId(1L);
        customer.setTransactions(TestConstants.getTransactionList());
        Mockito.when(customerService.getCustomerById(1L)).thenReturn(customer);
        int rewards = customerRewards.getTotalPoints(1L);
        assertEquals(150, rewards);
    }

    @Test
    void testGetMonthylReport() {
        Customer customer = new Customer();
        customer.setCustomerId(1L);
        customer.setTransactions(TestConstants.getTransactionList());
        Mockito.when(customerService.getCustomerById(1L)).thenReturn(customer);
        Map<String, Object> monthlyReportMap = customerRewards.getMonthlyReport(1L);
        assertNotNull(monthlyReportMap);
        assertEquals(1L, monthlyReportMap.get("customerId"));
        assertEquals(60, monthlyReportMap.get("JANUARY"));
        assertEquals(0, monthlyReportMap.get("FEBRUARY"));
        assertEquals(90, monthlyReportMap.get("MARCH"));
    }

}