package manu.pruebaelastic.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import manu.pruebaelastic.model.Author;
import manu.pruebaelastic.services.AuthorService;

@RestController
@RequestMapping("/author")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping()
    public List<Author> getAllAuthors() {
        return authorService.findAll();
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping
    public Author createAuthor(@RequestBody Author author) {
        return this.authorService.addAuthor(author);
    }

    // @PostMapping("/{authid}/new-article")
    // public void addArticleToAuthor(@PathVariable("authid") String authid,
    // @RequestBody Article article) {
    // // Author author = authorService.findById(authid);
    // authorService.addArticleToAuthor(authid, article);
    // }
}
