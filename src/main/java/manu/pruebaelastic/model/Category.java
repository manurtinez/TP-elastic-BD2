package manu.pruebaelastic.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * Clase que representa una categoria
 */
@Document(indexName = "category")
public class Category {

  /**
   * Clave primaria del objeto
   */
  @Id
  private String id;

  /**
   * Constructor vacio necesario
   */
  public Category() {
  }

  /**
   * Constructor para la clase Categoria
   * 
   * @param name El nombre de la categoria
   */
  public Category(String name) {
    this.setName(name);
  }

  /**
   * Nombre de la categoria
   */
  private String name;

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
