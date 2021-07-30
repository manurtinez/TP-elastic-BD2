package manu.pruebaelastic.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import manu.pruebaelastic.model.Article;
import manu.pruebaelastic.services.ArticleService;

@RestController
@RequestMapping("/article")
public class ArticleController {

  private final ArticleService articleService;

  public ArticleController(ArticleService articleService) {
    this.articleService = articleService;
  }

  @ResponseStatus(HttpStatus.ACCEPTED)
  @PostMapping
  public Article createArticle(@RequestBody Article article) {
    System.out.println(article);
    return this.articleService.addArticle(article);
  }
}
