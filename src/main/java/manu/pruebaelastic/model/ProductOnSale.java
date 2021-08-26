package manu.pruebaelastic.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * Clase que representa el historial de cambios de precio para un determinado
 * producto
 */

@Document(indexName = "productonsaleindex")
public class ProductOnSale {

  @Id
  private String id;

  /**
   * Id de producto correspondiente
   */

  private List<Product> products = new ArrayList<Product>();

  /**
   * Precio actual del producto
   */
  private Float price;

  /**
   * Fecha de cambio / creación del precio
   */
  private Date initialDate;

  /**
   * Fecha de fin del precio. Inicia en null
   */
  private Date finalDate = null;

  /**
   * Constructor vacio
   */
  public ProductOnSale() {
  }

  /**
   * Constructor
   * 
   * @param product     El producto correspondiente
   * @param provider    El provider correspondiente
   * @param price       Precio para el producto
   * @param initialDate Fecha para llevar el historial
   */
  public ProductOnSale(float price, Date initialDate) {
    this.setPrice(price);
    this.setInitialDate(initialDate);
  }

  public float getPrice() {
    return this.price;
  }

  public void setPrice(float price) {
    this.price = price;
  }

  public Date getInitialDate() {
    return this.initialDate;
  }

  public void setInitialDate(Date initialDate) {
    this.initialDate = initialDate;
  }

  public String getId() {
    return this.id;
  }

  public Date getFinalDate() {
    return this.finalDate;
  }

  public void setFinalDate(Date finalDate) {
    this.finalDate = finalDate;
  }

  public void addProduct(Product prod) {
    this.products.add(prod);
  }

  public List<Product> getProducts() {
    return products;
  }

}
