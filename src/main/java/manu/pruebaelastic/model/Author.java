package manu.pruebaelastic.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "authorid")
public class Author {

  @Id
  private String id;

  private String name;

  @Field(type = FieldType.Nested)
  private List<Article> articles;

  // Constructor
  public Author(String string) {
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
}
