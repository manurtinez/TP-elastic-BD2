package manu.pruebaelastic.services.impl;

import java.io.IOException;
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

  @Override
  public Category findByName(String id) {
    return categoryRepository.findByName(id).get();
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

  @Override
  public Category getCategoryWithLessProducts() throws IOException {
    String resultName = this.categoryRepository.getCategoryWithLessProducts();
    Optional<Category> cat = this.categoryRepository.findByName(resultName);
    return cat.isPresent() ? cat.get() : null;
  }

}
