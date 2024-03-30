package com.example.library.services;


import com.example.library.models.Author;
import com.example.library.models.Book;
import com.example.library.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(Book book){
        bookRepository.save(book);
    }

    public Optional<Book> getBookById(Long id){
        return bookRepository.findById(id);
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public List<Book> getBookByAuthor(Author author){
        return bookRepository.findBookByAuthor(author);
    }

    public Book getBookByTitle(String title){
        return bookRepository.findBookByTitle(title);
    }

    public List<Book> getBookByGenre(String genre){
        return bookRepository.findBooksByGenre(genre);
    }

    public Book updateBook(Book book){
       return bookRepository.save(book);
    }




    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }

}
