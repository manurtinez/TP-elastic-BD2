package manu.pruebaelastic.services;

import java.util.List;

import manu.pruebaelastic.model.Category;

public interface CategoryService {
  List<Category> findAll();

  Category createOrGetCategory(Category cat);
}
