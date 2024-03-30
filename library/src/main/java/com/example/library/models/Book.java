package com.example.library.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long bookId;
    private String title;
    private String genre;
    private String isbn;
    private String publishedDate;
    private int quantity;
    private int availableQuantity;

    @ManyToOne
    private Author author;

    @OneToMany
    private List<BookTransaction> transactions;


    public Book() {
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<BookTransaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<BookTransaction> transactions) {
        this.transactions = transactions;
    }

    public Book(Long bookId, String title, String genre, String isbn, String publishedDate, int quantity, int availableQuantity, Author author) {
        this.bookId = bookId;
        this.title = title;
        this.genre = genre;
        this.isbn = isbn;
        this.publishedDate = publishedDate;
        this.quantity = quantity;
        this.availableQuantity = availableQuantity;
        this.author = author;
    }
}
