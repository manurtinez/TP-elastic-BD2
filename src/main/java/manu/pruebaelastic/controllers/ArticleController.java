package manu.pruebaelastic.controllers;

import manu.pruebaelastic.model.Author;
import manu.pruebaelastic.repositories.ArticleRepository;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import manu.pruebaelastic.model.Article;
import manu.pruebaelastic.services.ArticleService;
import manu.pruebaelastic.services.AuthorService;

@RestController
@RequestMapping("/article")
public class ArticleController {

  private final ArticleService articleService;

  // private final AuthorRepository authorRepository;
  private final AuthorService authorService;

  private final ArticleRepository articleRepository;

  public ArticleController(ArticleService articleService, AuthorService authorService,
      ArticleRepository articleRepository) {
    this.articleService = articleService;
    this.authorService = authorService;
    this.articleRepository = articleRepository;
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping("/all")
  public List<Article> getAllArticles() {
    return this.articleService.getAll();
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping()
  public Article getArticleById(String id) {
    return this.articleService.getById(id);
  }

  @ResponseStatus(HttpStatus.ACCEPTED)
  @PostMapping("/{authid}")
  public Article createArticle(@PathVariable("authid") String authid, @RequestBody Article article) {
    try {
      // Traer autor y asignarlo al nuevo article
      Author author = authorService.findById(authid);
      article.setAuthor(author);

      // Crear article y retornarlo
      return articleService.addArticle(article);

      // Esto era para agregar el article al array del author

      // authorService.addArticleToAuthor(authid, article);
      // author.addArticle(article);
      // authorRepository.save(author); // mmmm idk bro
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  @ResponseStatus(HttpStatus.NO_CONTENT)
  @DeleteMapping("/{artid}")
  public void deleteArticle(@PathVariable("artid") String artid) {
    try {
      Article article = articleRepository.findById(artid).get();
      this.articleService.deleteArticle(article);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
