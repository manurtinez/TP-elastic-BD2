package manu.pruebaelastic.services.impl;

import java.util.List;

import manu.pruebaelastic.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import manu.pruebaelastic.model.Article;
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
    return articleRepository.save(article);
  }

  @Override
  public List<Article> getAll() {
    return articleRepository.findAll();
  }

  @Override
  public Article getById(String id) {
    return articleRepository.findById(id).get();
  }

  @Override
  public Article editArticle(Article article) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void deleteArticle(Article article) {
    articleRepository.delete(article);
  }
}
