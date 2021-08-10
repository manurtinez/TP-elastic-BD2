package manu.pruebaelastic.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "purchase")
public class Purchase {

  @Id
  private String id;

  // @ManyToOne(fetch = FetchType.LAZY)
  // @JoinColumn(name = "product_on_sale_id", nullable = false)
  // private ProductOnSale productOnSale;

  private int quantity;

  private DeliveryMethod deliveryMethod;

  // @ManyToOne(fetch = FetchType.LAZY)
  // @JoinColumn(name = "payment_method_id", nullable = false)
  // private PaymentMethod paymentMethod;

  private String address;

  private Float coordX;

  private Float coordY;

  @Field(type = FieldType.Date, format = {}, pattern = "uuuu-MM-dd'T'HH:mm:ssz")
  private Date dateOfPurchase;

  public Purchase() {
  }

  public Purchase(
      // ProductOnSale productOnSale,
      int quantity, User client, DeliveryMethod deliveryMethod,
      // PaymentMethod paymentMethod,
      String address, Float coordX, Float coordY, Date dateOfPurchase) {
    // this.productOnSale = productOnSale;
    this.quantity = quantity;
    this.deliveryMethod = deliveryMethod;
    // this.paymentMethod = paymentMethod;
    this.address = address;
    this.coordX = coordX;
    this.coordY = coordY;
    this.setDateOfPurchase(dateOfPurchase);
  }

  // * Getters and setters

  public String getId() {
    return this.id;
  }

  // public ProductOnSale getProductOnSale() {
  // return this.productOnSale;
  // }

  // public void setProductOnSale(ProductOnSale productOnSale) {
  // this.productOnSale = productOnSale;
  // }

  public int getQuantity() {
    return this.quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public DeliveryMethod getDeliveryMethod() {
    return this.deliveryMethod;
  }

  public void setDeliveryMethod(DeliveryMethod deliveryMethod) {
    this.deliveryMethod = deliveryMethod;
  }

  // public PaymentMethod getPaymentMethod() {
  // return this.paymentMethod;
  // }

  // public void setPaymentMethod(PaymentMethod paymentMethod) {
  // this.paymentMethod = paymentMethod;
  // }

  public String getAddress() {
    return this.address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Float getCoordX() {
    return this.coordX;
  }

  public void setCoordX(Float coordX) {
    this.coordX = coordX;
  }

  public Float getCoordY() {
    return this.coordY;
  }

  public void setCoordY(Float coordY) {
    this.coordY = coordY;
  }

  public Date getDateOfPurchase() {
    return this.dateOfPurchase;
  }

  public void setDateOfPurchase(Date dateOfPurchase) {
    this.dateOfPurchase = dateOfPurchase;
  }

  // * Fin getters and setters

  /**
   * Retorna el monto total a pagar, es decir: Cantidad de productos, por precio
   * por producto, mas precio de envío
   * 
   * @return monto total
   */
  // public Float getAmount() {
  // return (this.quantity * this.productOnSale.getPrice()) +
  // this.deliveryMethod.getCost();
  // }

}
