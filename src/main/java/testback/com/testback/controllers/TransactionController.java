package testback.com.testback.controllers;

import java.util.ArrayList;
import java.util.List;
import testback.com.testback.models.Transaction;
import testback.com.testback.repositories.TransactionRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    // @Autowired
    final TransactionRepository transactionRepository;

    public TransactionController(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @GetMapping

    public ResponseEntity<List<Transaction>> getAllTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        transactions = transactionRepository.findAll();
        return new ResponseEntity<>(transactions, HttpStatus.OK);

    }


  
}
