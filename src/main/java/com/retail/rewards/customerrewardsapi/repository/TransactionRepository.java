package com.retail.rewards.customerrewardsapi.repository;

import com.retail.rewards.customerrewardsapi.dao.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    @Query(nativeQuery = true,
            value = "SELECT SUM(transaction_rewards) FROM Transaction t where t.customer_id= :id")
    Long getTotalRewardPointForCustomer(@Param("id") Long id);


}
