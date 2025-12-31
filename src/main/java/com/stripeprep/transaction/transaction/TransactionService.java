package com.stripeprep.transaction.transaction;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TransactionService {

    private final List<Transaction> transactions = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public Transaction createTransaction(Long userId, long amount, TransactionType type) {

        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }

        Transaction transaction = new Transaction(
                idGenerator.getAndIncrement(),
                userId,
                amount,
                type
        );

        transactions.add(transaction);
        return transaction;
    }

    public List<Transaction> getTransactionsForUser(Long userId) {
        return transactions.stream()
                .filter(t -> t.getUserId().equals(userId))
                .toList();
    }
}
