package com.example.library.services;

import com.example.library.exception.TransactionNotFoundException;
import com.example.library.models.Book;
import com.example.library.models.BookTransaction;
import com.example.library.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    private TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }


    public List<BookTransaction> getTransactionList (){
       return transactionRepository.findAll();
    }


    public List<BookTransaction> getTransactionByUserId(Long userId){
       return transactionRepository.getBookTransactionsByUserId(userId);
    }

    public void borrowBook(Long userId, Book book) {

        BookTransaction transaction = new BookTransaction();
        transaction.setUserId(userId);
        transaction.setBook(book);
        transaction.setReturned(false);
        transactionRepository.save(transaction);
    }

    public List<Book> getBorrowedBooks(){
        return transactionRepository.findByReturnedFalse();
    }

    public void returnBook(Long transactionId) {
        Optional<BookTransaction> optionalTransaction = transactionRepository.findById(transactionId);
        if (optionalTransaction.isPresent()) {
            BookTransaction transaction = optionalTransaction.get();
            transaction.setReturned(true);
            transactionRepository.save(transaction);
        }

        else {

            throw new TransactionNotFoundException("Transaction with ID " + transactionId + " does not exist");

        }

    }



}
