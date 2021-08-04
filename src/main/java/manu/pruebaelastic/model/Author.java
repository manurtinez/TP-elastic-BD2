package manu.pruebaelastic.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "author")
public class Author {

  @Id
  private String id;

  private String name;

//  @Field(type = FieldType.Nested)
//  private List<Article> articles;

  // Default constructor
  public Author() {
  }

  // Constructor
  public Author(String aName) {
    this.name = aName;
//    this.articles = new ArrayList<>();
  }

  // Getters & Setters
  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

//  public List<Article> getArticles() {
//    return this.articles;
//  }
//
//  public void setArticles(List<Article> articles) {
//    this.articles = articles;
//  }
//
//  public void addArticle(Article article) {
//    this.articles.add(article);
//  }
}
