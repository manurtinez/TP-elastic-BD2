package manu.pruebaelastic.services.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.BucketOrder;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import manu.pruebaelastic.model.Category;
import manu.pruebaelastic.repositories.CategoryRepository;
import manu.pruebaelastic.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

  @Autowired
  private CategoryRepository categoryRepository;

  @Autowired
  private RestHighLevelClient client;

  CategoryServiceImpl(CategoryRepository categoryRepository, RestHighLevelClient client) {
    this.client = client;
    this.categoryRepository = categoryRepository;
  }

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
    // Se crea la aggregation, con nombre "less_category", que tiene en cuenta el
    // campo "category.name" (keyword es para indicar el tipo de dato de elastic), y
    // orden por count, ascendente (queremos el primero, menor)
    TermsAggregationBuilder aggregation = AggregationBuilders.terms("less_category").field("category.name.keyword")
        .order(BucketOrder.aggregation("_count", true));

    // Creo un builder para la busqueda, que usa la aggregation anterior y un tamaño
    // de 1 (me esta ignorando ese size, pero se supone que deberia limitarlo)
    SearchSourceBuilder builder = new SearchSourceBuilder().aggregation(aggregation).size(1);

    // Luego se asigna ese builder al request que se va a hacer para el indice
    // "product"
    SearchRequest searchRequest = new SearchRequest("product").source(builder);

    // Se hace la busqueda efectiva y se extraen los resultados, de tipo Terms
    // (porque la aggregation fue terms),
    // para la aggregation con nombre "less_category".
    SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
    Terms terms = response.getAggregations().get("less_category");

    // No pude encontrar forma de traer directamente el documento desde el
    // aggregation, asi que hago un get
    // con la key (el nombre, ya que busque sobre category.name).
    String resultName = terms.getBuckets().get(0).getKeyAsString();
    return this.categoryRepository.findByName(resultName).get();
  }

}
