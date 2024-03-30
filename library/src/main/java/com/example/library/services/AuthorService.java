package com.example.library.services;


import com.example.library.models.Author;
import com.example.library.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {


    private AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public void addAuthor(Author author){
        authorRepository.save(author);
    }

    public Optional<Author> getAuthorById(Long id){
       return authorRepository.findById(id);
    }

    public Author getAuthorByName(String name){
      return authorRepository.getAuthorByName(name);
    }

    public List<Author> getAllAuthor(){return authorRepository.findAll();}
    public Author updateAuthor(Author author){
       return authorRepository.save(author);

    }

    public void deleteAuthor(Author author){
        authorRepository.delete(author);
    }
    public void deleteAuthorById(Long id){
        authorRepository.deleteById(id);
    }


}
