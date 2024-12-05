package testback.com.testback.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import testback.com.testback.models.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository <Transaction,Long> {
    
}
