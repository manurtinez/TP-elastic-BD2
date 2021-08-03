package manu.pruebaelastic.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import manu.pruebaelastic.model.Author;
import manu.pruebaelastic.repositories.AuthorRepository;
import manu.pruebaelastic.services.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author addAuthor(Author author) {
        Author newAuthor = new Author(author.getName());
        return authorRepository.save(newAuthor);
    }

}
