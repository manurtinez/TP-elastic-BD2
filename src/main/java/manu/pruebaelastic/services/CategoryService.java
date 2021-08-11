package manu.pruebaelastic.services;

import java.util.List;

import manu.pruebaelastic.model.Category;
import manu.pruebaelastic.model.Product;

public interface CategoryService {
  List<Category> findAll();

  Category createOrGetCategory(Category cat);

  void addProductToCategory(Category cat, Product prod);
}
