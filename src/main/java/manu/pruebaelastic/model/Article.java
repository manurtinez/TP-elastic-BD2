package manu.pruebaelastic.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "article")
public class Article {

  @Id
  private String id;

  private String title;

  @Field(type = FieldType.Nested)
  private Author author;

  // Default constructor
  public Article() {
  }

  // Constructor
  public Article(String aTitle) {
    this.title = aTitle;
  }

  // getters and setters
  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Author getAuthor() {
    return this.author;
  }

  public void setAuthor(Author author) {
    this.author = author;
    // author.addArticle(this); // Tengo mis dudas con estop
  }
}
