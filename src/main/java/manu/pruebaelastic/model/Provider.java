package manu.pruebaelastic.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "providerindex")
public class Provider {

  @Id
  private String id;

  private String name;

  private List<ProductOnSale> productsonsale= new ArrayList<ProductOnSale>();

  private Long cuit;

  /**
   * Constructor vacio
   */
  public Provider() {
  }

  /**
   * Constructor
   * 
   * @param name Nombre de proveedor // * @param products Lista de productos del
   *             proveedor
   * @param cuit CUIT del proveedor
   */
  public Provider(String name, Long cuit) {
    this.setName(name);
    // this.products = new ArrayList<Product>();
    this.setCuit(cuit);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

//  public void changeProductPrice(Product p, long newPrice) {
//    // TODO
//    // aca se cambiaria el precio de un producto en especifico, agregando un
//    // nuevo ProductPrice?
//    // int index = this.products.indexOf(p);
//
//  }

  public Long getCuit() {
    return cuit;
  }

  public void setCuit(Long cuit) {
    this.cuit = cuit;
  }

  public String getId() {
    return id;
  }
  
  public void addProductOnSale(ProductOnSale pos) {
	    this.productsonsale.add(pos);
	  }
  
  public List<ProductOnSale> getProductsOnSale() {
	    return productsonsale;
	  }

}
