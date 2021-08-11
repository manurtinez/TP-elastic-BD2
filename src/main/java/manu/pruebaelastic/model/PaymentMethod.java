package manu.pruebaelastic.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "payment_method")
public class PaymentMethod {
  /**
   * Clave primaria del objeto
   */
  @Id
  private String id;

  /**
   * Nombre del método de pago
   */
  private String name;

  /**
   * Tipo de payment method (sacamos hijos de la jerarquía)
   */
  private String paymentType;

  /**
   * Promised amount para el tipo OnDeliveryPayment
   */
  private Float promisedAmount;

  /**
   * Datos para el tipo CreditCardPayment
   */
  private String brand;
  private Long number;
  private Integer cvv;
  private String owner;

  @Field(type = FieldType.Date, format = {}, pattern = "uuuu-MM-dd'T'HH:mm:ssz")
  private Date expiry;

  /**
   * Constructor vacío
   */
  public PaymentMethod() {
  }

  /**
   * Constructor de super clase
   * 
   * @param id
   * @param name
   */
  public PaymentMethod(String name) {
    this.name = name;
  }

  /**
   * Constructor para el tipo OnDeliveryPayment
   * 
   * @param name
   * @param promisedAmount
   */
  public PaymentMethod(String name, String paymentType, Float promisedAmount) {
    this.paymentType = paymentType;
    this.name = name;
    this.promisedAmount = promisedAmount;
  }

  /**
   * Constructor para el tipo CreditCardPayment
   * 
   * @param name
   * @param brand
   * @param number
   * @param cvv
   * @param owner
   * @param expiry
   */
  public PaymentMethod(String name, String paymentType, String brand, Long number, Integer cvv, String owner,
      Date expiry) {
    this.paymentType = paymentType;
    this.name = name;
    this.brand = brand;
    this.number = number;
    this.cvv = cvv;
    this.owner = owner;
    this.expiry = expiry;
  }

  // * Inicio setters / getters

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPaymentType() {
    return this.paymentType;
  }

  public void setPaymentType(String paymentType) {
    this.paymentType = paymentType;
  }

  public Float getPromisedAmount() {
    return this.promisedAmount;
  }

  public void setPromisedAmount(Float promisedAmount) {
    this.promisedAmount = promisedAmount;
  }

  public String getBrand() {
    return this.brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public Long getNumber() {
    return this.number;
  }

  public void setNumber(Long number) {
    this.number = number;
  }

  public Integer getCvv() {
    return this.cvv;
  }

  public void setCvv(Integer cvv) {
    this.cvv = cvv;
  }

  public String getOwner() {
    return this.owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
  }

  public Date getExpiry() {
    return this.expiry;
  }

  public void setExpiry(Date expiry) {
    this.expiry = expiry;
  }

  // * Fin getters / setters
}
