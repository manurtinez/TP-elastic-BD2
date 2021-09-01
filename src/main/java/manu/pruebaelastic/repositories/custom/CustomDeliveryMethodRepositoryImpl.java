package manu.pruebaelastic.repositories.custom;

import java.io.IOException;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;

import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.BucketOrder;
import org.elasticsearch.search.aggregations.bucket.nested.NestedAggregationBuilder;
import org.elasticsearch.search.aggregations.bucket.nested.ParsedNested;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomDeliveryMethodRepositoryImpl implements CustomDeliveryMethodRepository {

  @Autowired
  private RestHighLevelClient client;

  public CustomDeliveryMethodRepositoryImpl(RestHighLevelClient client) {
    this.client = client;
  }

  public String getMostUsedDeliveryMethod() throws IOException {
    // Hace falta crear una aggregation de tipo nested para hacer aggregate de datos
    // dentro del array purchases (que es de tipo nested)
    NestedAggregationBuilder aggregation = AggregationBuilders.nested("nested", "purchases")
        .subAggregation(AggregationBuilders.terms("top_delivery").field("purchases.deliveryMethod.name.keyword")
            .order(BucketOrder.aggregation("_count", false)));

    SearchSourceBuilder builder = new SearchSourceBuilder().aggregation(aggregation);
    SearchRequest request = new SearchRequest("user").source(builder);

    SearchResponse response = client.search(request, RequestOptions.DEFAULT);

    // La aggregation al ser nested retorna un tipo ParsedNested, el cual tiene la
    // otra aggregation adentro
    ParsedNested nestedAggrResults = response.getAggregations().get("nested");

    // Se extrae la aggregation de adentro de la nested
    Terms deliveryResults = (Terms) nestedAggrResults.getAggregations().asMap().get("top_delivery");

    // Se retorna el nombre del primer resultado, que como esta ordenado de forma
    // decreciente, sera el mas usado
    return deliveryResults.getBuckets().get(0).getKeyAsString();
  }

}
