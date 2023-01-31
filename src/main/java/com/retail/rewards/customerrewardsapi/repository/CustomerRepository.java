package com.retail.rewards.customerrewardsapi.repository;

import com.retail.rewards.customerrewardsapi.dao.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
