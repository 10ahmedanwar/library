package com.example.library.repositories;

import com.example.library.models.Author;
import com.example.library.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

    List<Book> findBookByAuthor(Author author);
    Book findBookByTitle(String title);
    List<Book> findBooksByGenre(String genre);

}
