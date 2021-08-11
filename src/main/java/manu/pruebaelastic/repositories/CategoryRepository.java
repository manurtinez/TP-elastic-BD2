package manu.pruebaelastic.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import manu.pruebaelastic.model.Category;

public interface CategoryRepository extends ElasticsearchRepository<Category, String> {
  List<Category> findAll();

  Optional<Category> findByName(String name);
}
