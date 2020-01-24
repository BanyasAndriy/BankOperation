package ado;

import Entity.Transaction;

import java.util.List;

public interface TransactionAdo {

    List<Transaction> getTransactionsByCard(String card);

}
