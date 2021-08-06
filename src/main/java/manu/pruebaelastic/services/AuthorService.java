package manu.pruebaelastic.services;

import java.util.List;

import manu.pruebaelastic.model.Article;
import manu.pruebaelastic.model.Author;

public interface AuthorService {
    List<Author> findAll();

    Author findById(String id);

    Author addAuthor(Author author);

    // void addArticleToAuthor(String id, Article article);
}
