package testback.com.testback.controllers;

// import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import testback.com.testback.models.Transaction;
import testback.com.testback.repositories.TransactionRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public ResponseEntity<?> getAllTransactions() {
        try {
            List<Transaction> transactions = new ArrayList<>();
            transactions = transactionRepository.findAll();
            return new ResponseEntity<>(transactions, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to fetch transactions", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @PostMapping
    public ResponseEntity<String> createTransaction(@RequestBody Transaction transaction) {
        try {
            Transaction newTransaction = transactionRepository.save(transaction);
            return new ResponseEntity<>("Transaction created successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to create transaction", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTransaction(@PathVariable("id") Long id) {
        try {
            Transaction transaction = transactionRepository.findById(id).orElse(null);
            if (transaction == null) {
                return new ResponseEntity<>("Transaction not found", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(transaction, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to retrieve transaction", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // put
    @PutMapping("/{id}")
    public ResponseEntity<?> updateTransaction(@PathVariable("id") long id, @RequestBody Transaction transaction) {
        try {
            Optional<Transaction> transactionData = transactionRepository.findById(id);

            if (transactionData.isPresent()) {
                Transaction transactionToUpdate = transactionData.get();
                transactionToUpdate.setDescription(transaction.getDescription());
                transactionToUpdate.setType(transaction.getType());
                transactionToUpdate.setAmount(transaction.getAmount());

                // Format the date
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
                String formattedDate = dateFormat.format(transaction.getDate());
                try {
                    Date parsedDate = dateFormat.parse(formattedDate);
                    transactionToUpdate.setDate(parsedDate);
                } catch (ParseException e) {
                    e.printStackTrace();
                    return new ResponseEntity<>("Invalid date format", HttpStatus.BAD_REQUEST);
                }

                transactionRepository.save(transactionToUpdate);
                return new ResponseEntity<>(transactionToUpdate, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Transaction not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to update transaction", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // delete
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTransaction(@PathVariable("id") Long id) {
        try {
            if (transactionRepository.existsById(id)) {
                transactionRepository.deleteById(id);
                return new ResponseEntity<>("Transaction deleted successfully", HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>("Transaction not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to delete transaction", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    }





  

