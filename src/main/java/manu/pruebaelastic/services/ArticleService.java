package manu.pruebaelastic.services;

import java.util.List;

import manu.pruebaelastic.model.Article;

public interface ArticleService {
  List<Article> getAll();

  Article getById(String id);

  Article addArticle(Article article);

  Article editArticle(Article article);

  void deleteArticle(Article article);
}
