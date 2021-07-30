package manu.pruebaelastic.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import manu.pruebaelastic.model.Article;
import manu.pruebaelastic.model.Author;
import manu.pruebaelastic.repositories.ArticleRepository;

@Service
public class ArticleServiceImpl implements ArticleService {

  @Autowired
  private final ArticleRepository articleRepository;

  public ArticleServiceImpl(ArticleRepository articleRepository) {
    this.articleRepository = articleRepository;
  }

  public Article addArticle(Article article) {
    // Article article2 = new Article("an article");
    // List<Author> authorsList = new ArrayList<Author>();
    // authorsList.add(new Author("manuelito"));
    // authorsList.add(new Author("manuelito2"));
    // article.setAuthors(authorsList);
    Article newArt = articleRepository.save(article);
    return newArt;
  }
}
