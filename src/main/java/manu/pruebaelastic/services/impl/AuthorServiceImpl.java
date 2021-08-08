package manu.pruebaelastic.services.impl;

import java.util.List;

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

    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    // @Override
    // public void addArticleToAuthor(String id, Article article) {
    // Author author = authorRepository.findById(id).get();
    // author.addArticle(article);
    // authorRepository.save(author);
    // }

    @Override
    public Author findById(String id) {
        return authorRepository.findById(id).get();
    }

}
