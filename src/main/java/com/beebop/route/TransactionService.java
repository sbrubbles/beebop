package com.beebop.route;

import com.beebop.model.Transaction;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class TransactionService {
    public List<Transaction> list() {
        Transaction transaction = new Transaction();
        transaction.setId("10");
        transaction.setAccountId("20");
        transaction.setCounterpartyAccount("jaisj");
        return Arrays.asList(transaction);
    }
}
