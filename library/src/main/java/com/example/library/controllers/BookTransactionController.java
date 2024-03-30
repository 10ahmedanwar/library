package com.example.library.controllers;

import com.example.library.models.Book;
import com.example.library.models.BookTransaction;
import com.example.library.services.TransactionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/transactions")
@Validated
public class BookTransactionController {
    private final TransactionService transactionService;

    @Autowired
    public BookTransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }


    @PostMapping("/borrow")
    public ResponseEntity<String> borrowBook(@Valid@RequestBody Long userId,@Valid@RequestBody Book book) {
        transactionService.borrowBook(userId,book);
        return ResponseEntity.status(HttpStatus.CREATED).body("Book borrowed successfully");
    }

    @PutMapping("/return/{transactionId}")
    public ResponseEntity<String> returnBook(@Valid@PathVariable Long transactionId) {
        transactionService.returnBook(transactionId);
        return ResponseEntity.ok("Book returned successfully");
    }


    @GetMapping("/borrowed")
    public ResponseEntity<List<@Valid Book>> getAllBorrowedBooks() {
        List<Book> borrowedBooks = transactionService.getBorrowedBooks();
        return ResponseEntity.ok(borrowedBooks);
    }



    @GetMapping("/all")
    public ResponseEntity<List<BookTransaction>> getAllTransactions() {
        List<BookTransaction> transactions = transactionService.getTransactionList();
        return ResponseEntity.ok(transactions);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<@Valid BookTransaction>> getTransactionsByUserId(@PathVariable Long userId) {
        List<BookTransaction> bookTransactions = transactionService.getTransactionByUserId(userId);
        return ResponseEntity.ok(bookTransactions);
    }




}