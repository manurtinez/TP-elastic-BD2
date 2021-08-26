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

  private int quantity;

  private DeliveryMethod deliveryMethod;

  private PaymentMethod paymentMethod;

  private String address;

  private Float coordX;

  private Float coordY;

  @Field(type = FieldType.Date, format = {}, pattern = "uuuu-MM-dd'T'HH:mm:ssz")
  private Date dateOfPurchase;

  public Purchase() {
  }

  public Purchase(
      // ProductOnSale productOnSale,
      int quantity, User client, DeliveryMethod deliveryMethod, PaymentMethod paymentMethod, String address,
      Float coordX, Float coordY, Date dateOfPurchase) {
    // this.productOnSale = productOnSale;
    this.quantity = quantity;
    this.deliveryMethod = deliveryMethod;
    this.paymentMethod = paymentMethod;
    this.address = address;
    this.coordX = coordX;
    this.coordY = coordY;
    this.setDateOfPurchase(dateOfPurchase);
  }

  // * Getters and setters

  public String getId() {
    return this.id;
  }

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

  public PaymentMethod getPaymentMethod() {
    return this.paymentMethod;
  }

  public void setPaymentMethod(PaymentMethod paymentMethod) {
    this.paymentMethod = paymentMethod;
  }

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

}
