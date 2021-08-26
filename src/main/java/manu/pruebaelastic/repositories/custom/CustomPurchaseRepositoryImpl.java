package manu.pruebaelastic.repositories.custom;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import manu.pruebaelastic.model.Purchase;

public class CustomPurchaseRepositoryImpl implements CustomPurchaseRepository {

  private RestHighLevelClient client;

  @Autowired
  public CustomPurchaseRepositoryImpl(RestHighLevelClient client) {
    this.client = client;
  }

  @Override
  public List<Purchase> getPurchasesInPeriod(Date start, Date end) throws IOException {

    // Creo el search request con el index(es) a buscar
    SearchRequest searchRequest = new SearchRequest("purchase");

    // Defino el formato que tendra la fecha
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssz");

    // Creo el query builder, que define como se va a construir la query efectiva a
    // hacer
    QueryBuilder queryBuilder = QueryBuilders.boolQuery()
        .must(QueryBuilders.rangeQuery("dateOfPurchase").gte(dateFormat.format(start)).lte(dateFormat.format(end)));

    // Creo el search source builder con la query anterior, y se lo asigno al
    // request
    SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
    searchSourceBuilder.query(queryBuilder);
    searchRequest.source(searchSourceBuilder);

    // Se hace la busqueda
    SearchResponse res = client.search(searchRequest, RequestOptions.DEFAULT);

    return getSearchResult(res);
  }

  /**
   * Esta funcion convierte los objetos raw retornados por el query a objetos
   * Java. Se podria ver una forma de hacerla generica para que no este atada a
   * cada repository y repetida
   * 
   * @param response El response del query ejecutado
   * @return La lista de purchases como POJOs
   */
  private List<Purchase> getSearchResult(SearchResponse response) {

    List<Purchase> purchasesInPeriod = new ArrayList<Purchase>();

    SearchHit[] hits = response.getHits().getHits();

    // El mapper requeria especificar el formato de fecha especifico o tiraba error
    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssz").create();

    for (SearchHit hit : hits) {
      JsonElement jsonElement = gson.toJsonTree(hit.getSourceAsMap());
      purchasesInPeriod.add(gson.fromJson(jsonElement, Purchase.class));
    }

    return purchasesInPeriod;
  }

}
