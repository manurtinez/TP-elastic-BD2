package manu.pruebaelastic.controllers;

import manu.pruebaelastic.model.Author;
import manu.pruebaelastic.repositories.AuthorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import manu.pruebaelastic.model.Article;
import manu.pruebaelastic.services.ArticleService;

@RestController
//@RequestMapping("/article")
public class ArticleController {

  private final ArticleService articleService;

  private final AuthorRepository authorRepository;

  public ArticleController(ArticleService articleService, AuthorRepository authorRepository) {
    this.articleService = articleService;
    this.authorRepository = authorRepository;
  }

  @ResponseStatus(HttpStatus.ACCEPTED)
  @PostMapping("/article/{authid}")
  public Article createArticle(@PathVariable("authid") String authid, @RequestBody Article article) {
    System.out.println(article);
    try {
      Author author = authorRepository.findById(authid).get();
      System.out.println(author);
//      author.addArticle(article);
      authorRepository.save(author);
      return this.articleService.addArticle(article);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }}
}
