package manu.pruebaelastic.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import manu.pruebaelastic.model.Category;
import manu.pruebaelastic.repositories.CategoryRepository;
import manu.pruebaelastic.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

  @Autowired
  private CategoryRepository categoryRepository;

  CategoryServiceImpl(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  @Override
  public Category createOrGetCategory(Category cat) {
    Optional<Category> retrievedCategory = categoryRepository.findByName(cat.getName());
    if (!retrievedCategory.isPresent()) {
      return categoryRepository.save(cat);
    } else {
      return retrievedCategory.get();
    }
  }

  @Override
  public List<Category> findAll() {
    return categoryRepository.findAll();
  }

}
