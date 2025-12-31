package com.stripeprep.transaction.controller;

import com.stripeprep.transaction.transaction.CreateTransactionRequest;
import com.stripeprep.transaction.transaction.Transaction;
import com.stripeprep.transaction.transaction.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(
            @RequestBody CreateTransactionRequest request
    ) {
        Transaction transaction = transactionService.createTransaction(
                request.userId(),
                request.amount(),
                request.type()
        );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(transaction);
    }

    @GetMapping("/user/{userId}")
    public List<Transaction> getUserTransactions(
            @PathVariable Long userId
    ) {
        return transactionService.getTransactionsForUser(userId);
    }
}
