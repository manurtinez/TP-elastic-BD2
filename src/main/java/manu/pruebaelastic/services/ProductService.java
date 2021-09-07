package manu.pruebaelastic.services;

import java.io.IOException;
import java.util.List;

import manu.pruebaelastic.model.Category;
import manu.pruebaelastic.model.Product;

public interface ProductService {
  List<Product> findAll();

  Product createProduct(Product prod);

  List<Product> getProductsForCategory(Category cat) throws IOException;
}
