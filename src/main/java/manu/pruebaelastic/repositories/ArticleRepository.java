package manu.pruebaelastic.repositories;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import manu.pruebaelastic.model.Article;

@Repository
public interface ArticleRepository extends ElasticsearchRepository<Article, String> {

  List<Article> findByTitle(String name);

  // @Query("{\"bool\": {\"must\": [{\"match\": {\"authors.name\": \"?0\"}}]}}")
  // Page<Article> findByAuthorsNameUsingCustomQuery(String name, Pageable
  // pageable);

}
