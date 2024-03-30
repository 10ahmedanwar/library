package com.example.library.controllers;

import com.example.library.models.Author;
import com.example.library.services.AuthorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/authors")
@Validated
public class AuthorController {
    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addAuthor(@Valid @RequestBody Author author) {
        authorService.addAuthor(author);
        return ResponseEntity.status(HttpStatus.CREATED).body("Author added successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<@Valid Author>> getAuthorById(@PathVariable Long id) {
        Optional<Author> author = authorService.getAuthorById(id);
        if (author != null) {
            return ResponseEntity.ok(author);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<@Valid Author>> getAllAuthors() {
        List<Author> authors = authorService.getAllAuthor();
        return ResponseEntity.ok(authors);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateAuthor(@Valid@RequestBody Author author) {
        authorService.updateAuthor(author);
        return ResponseEntity.ok("Author updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthorById(id);
        return ResponseEntity.ok("Author deleted successfully");
    }
}
