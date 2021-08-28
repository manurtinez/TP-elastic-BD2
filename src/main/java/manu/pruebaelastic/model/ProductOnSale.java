package manu.pruebaelastic.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * Clase que representa el historial de cambios de precio para un determinado
 * producto
 */

@Document(indexName = "productonsale")
public class ProductOnSale {

  @Id
  private String id;

  /**
   * Objeto product dentro de product on sale
   */

  private Product product;

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
   * @param price       Precio para el producto
   * @param initialDate Fecha para llevar el historial
   */
  public ProductOnSale(Product product, float price, Date initialDate) {
    this.setProduct(product);
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

  public void setProduct(Product prod) {
    this.product = prod;
  }

  public Product getProduct() {
    return this.product;
  }

}
