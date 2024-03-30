package com.example.library.repositories;

import com.example.library.models.Book;
import com.example.library.models.BookTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<BookTransaction,Long> {
    List<BookTransaction> getBookTransactionsByUserId(Long userId);
    List<Book> findByReturnedFalse();
}
