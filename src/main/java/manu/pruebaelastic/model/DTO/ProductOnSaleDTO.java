package manu.pruebaelastic.model.DTO;

import java.util.Date;

/**
 * Clase que representa un objeto transitivo de product on sale, que REQUIERE el
 * ID del producto en cuestion
 */

public class ProductOnSaleDTO {

  /**
   * Id de producto correspondiente
   */

  private String product;

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

  public float getPrice() {
    return this.price;
  }

  public Date getInitialDate() {
    return this.initialDate;
  }

  public Date getFinalDate() {
    return this.finalDate;
  }

  public String getProduct() {
    return this.product;
  }

}
