package manu.pruebaelastic.repositories.custom;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import manu.pruebaelastic.model.Category;
import manu.pruebaelastic.model.Product;
import org.apache.lucene.search.join.ScoreMode;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomProductRepositoryImpl implements CustomProductRepository {
    private RestHighLevelClient client;

    @Autowired
    public CustomProductRepositoryImpl(RestHighLevelClient client) {
        this.client = client;
    }

    public List<Product> getProductsForCategory(Category cat) throws IOException {
        SearchRequest searchRequest = new SearchRequest("product");
        QueryBuilder queryBuilder = QueryBuilders.boolQuery()
                .must(
                        QueryBuilders.matchQuery(
                                "category.name", cat.getName())
                );
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(queryBuilder);
        searchRequest.source(searchSourceBuilder);
        SearchResponse res = client.search(searchRequest, RequestOptions.DEFAULT);
        return getSearchResult(res);
    }

    private List<Product> getSearchResult(SearchResponse response) {

        List<Product> products = new ArrayList<Product>();

        SearchHit[] hits = response.getHits().getHits();

        // El mapper requeria especificar el formato de fecha especifico o tiraba error
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssz").create();

        for (SearchHit hit : hits) {
            JsonElement jsonElement = gson.toJsonTree(hit.getSourceAsMap());
            products.add(gson.fromJson(jsonElement, Product.class));
        }

        return products;
    }

}
