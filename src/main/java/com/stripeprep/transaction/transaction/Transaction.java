package com.stripeprep.transaction.transaction;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.time.Instant;

public class Transaction {

    private Long id;

    @NotNull
    private Long userId;

    @Min(1)
    private long amount;

    @NotNull
    private TransactionType type;

    private Instant createdAt;

    public Transaction(Long id, Long userId, long amount, TransactionType type) {
        this.id = id;
        this.userId = userId;
        this.amount = amount;
        this.type = type;
        this.createdAt = Instant.now();
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public long getAmount() {
        return amount;
    }

    public TransactionType getType() {
        return type;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}
