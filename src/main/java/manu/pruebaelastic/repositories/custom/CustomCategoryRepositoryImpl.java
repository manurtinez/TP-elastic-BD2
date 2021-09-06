package manu.pruebaelastic.repositories.custom;

import java.io.IOException;

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

public class CustomCategoryRepositoryImpl implements CustomCategoryRepository {

  @Autowired
  private RestHighLevelClient client;

  CustomCategoryRepositoryImpl(RestHighLevelClient client) {
    this.client = client;
  }

  @Override
  public String getCategoryWithLessProducts() throws IOException {
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
    // aggregation, asi que devuelvo el nombre para hacer un get
    // con la key (el nombre, ya que busque sobre category.name)
    return terms.getBuckets().size() > 0 ? terms.getBuckets().get(0).getKeyAsString() : null;
  }

}
