package manu.pruebaelastic.services;

import java.util.List;

import manu.pruebaelastic.model.Product;

public interface ProductService {
  List<Product> findAll();

  Product createProduct(Product prod);
}
