package com.retail.rewards.customerrewardsapi.repository;

import com.retail.rewards.customerrewardsapi.dao.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
