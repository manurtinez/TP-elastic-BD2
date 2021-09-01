package manu.pruebaelastic.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * Clase que representa usuarios de la plataforma
 */
@Document(indexName = "user")
public class User {

  /**
   * Clave primaria del objeto usuario
   */
  @Id
  private String id;

  /**
   * Email del usuario
   */
  private String email;

  /**
   * Nombre completo del usuario
   */
  private String fullName;

  /**
   * Contraseña del usuario. Deberia ser un hash really
   */
  private String password;

  /**
   * Fecha de nacimiento del usuario
   */
  @Field(type = FieldType.Date, format = {}, pattern = "uuuu-MM-dd'T'HH:mm:ssz")
  private Date dayOfBirth;

  /**
   * Constructor vacio necesario
   */

  @Field(type = FieldType.Nested)
  private List<Purchase> purchases = new ArrayList<Purchase>();

  public User() {
  }

  /**
   * Constructor para la clase usuario
   * 
   * @param email      El email del usuario
   * @param fullName   El nombre completo del usuario
   * @param password   La contraseña para el usuario
   * @param dayOfBirth Fecha de nacimiento del usuario
   */
  public User(String email, String fullName, String password, Date dayOfBirth) {
    this.setEmail(email);
    this.setPassword(password);
    this.setFullName(fullName);
    this.setDayOfBirth(dayOfBirth);
  }

  public String getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public Date getDayOfBirth() {
    return dayOfBirth;
  }

  public void setDayOfBirth(Date birthDate) {
    this.dayOfBirth = birthDate;
  }

  public void addPurchase(Purchase pur) {
    this.purchases.add(pur);
  }

  public List<Purchase> getPurchases() {
    return purchases;
  }
}
