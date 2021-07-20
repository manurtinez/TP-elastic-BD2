package manu.pruebaelastic.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import manu.pruebaelastic.model.Article;
import manu.pruebaelastic.model.Author;
import manu.pruebaelastic.repositories.ArticleRepository;

@Service
public class ArticleService {
  private final ArticleRepository articleRepository;

  public ArticleService(ArticleRepository articleRepository) {
    this.articleRepository = articleRepository;
  }

  public void addArticle() {
    Article article = new Article("an article");
    List<Author> authorsList = new ArrayList<Author>();
    authorsList.add(new Author("manuelito"));
    authorsList.add(new Author("manuelito2"));
    // article.setAuthors(authorsList);
    articleRepository.save(article);
  }
}
