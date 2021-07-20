package manu.pruebaelastic.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "blog")
public class Article {

  @Id
  private String id;

  private String title;

  // @Field(type = FieldType.Nested, includeInParent = true)
  // private List<Author> authors;

  // Constructor
  public Article(String string) {
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

  // public List<Author> getAuthors() {
  // return this.authors;
  // }

  // public void setAuthors(List<Author> authors) {
  // this.authors = authors;
  // }
}
