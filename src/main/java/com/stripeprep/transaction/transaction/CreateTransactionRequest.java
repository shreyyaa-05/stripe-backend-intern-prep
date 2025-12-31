package com.stripeprep.transaction.transaction;

public record CreateTransactionRequest(
        Long userId,
        long amount,
        TransactionType type
) {}
