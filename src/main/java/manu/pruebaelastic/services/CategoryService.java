package manu.pruebaelastic.services;

import java.io.IOException;
import java.util.List;

import manu.pruebaelastic.model.Category;

public interface CategoryService {
  List<Category> findAll();

  Category findByName(String name);

  Category createOrGetCategory(Category cat);

  Category getCategoryWithLessProducts() throws IOException;
}
