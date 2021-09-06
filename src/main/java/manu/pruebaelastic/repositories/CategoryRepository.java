package manu.pruebaelastic.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import manu.pruebaelastic.model.Category;
import manu.pruebaelastic.repositories.custom.CustomCategoryRepository;

public interface CategoryRepository extends ElasticsearchRepository<Category, String>, CustomCategoryRepository {
  List<Category> findAll();

  Optional<Category> findByName(String name);
}
