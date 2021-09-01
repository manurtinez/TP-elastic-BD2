package manu.pruebaelastic.services.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.nested.NestedAggregationBuilder;
import org.elasticsearch.search.aggregations.bucket.nested.ParsedNested;
import org.elasticsearch.search.aggregations.bucket.terms.StringTerms;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import manu.pruebaelastic.model.Purchase;
import manu.pruebaelastic.model.User;
import manu.pruebaelastic.repositories.UserRepository;
import manu.pruebaelastic.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private RestHighLevelClient client;

    public UserServiceImpl(UserRepository userRepository, RestHighLevelClient client) {
        this.userRepository = userRepository;
        this.client = client;
    }

    @Override
    public User addUser(User user) {
        User newUser = new User(user.getEmail(), user.getFullName(), user.getPassword(), user.getDayOfBirth());
        return userRepository.save(newUser);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(String id) {
        System.out.println(id);
        return userRepository.findById(id).get();
    }

    @Override
    public void addPurchaseToUser(User user, Purchase pur) {
        user.addPurchase(pur);
        userRepository.save(user);
    }

    // ! Esta query NO FUNCIONA, es un work in progress
    @Override
    public List<User> getTopNUsersMorePurchases(int n) throws IOException {
        NestedAggregationBuilder aggregation = AggregationBuilders.nested("nested", "purchases")
                .subAggregation(AggregationBuilders.cardinality("top_by_purchases").field("purchases.purchase"));

        SearchSourceBuilder builder = new SearchSourceBuilder().aggregation(aggregation);

        SearchRequest request = new SearchRequest("user").source(builder);
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        Map<String, Aggregation> results = response.getAggregations().asMap();
        ParsedNested terms = response.getAggregations().get("nested");
        StringTerms topDel = (StringTerms) results.get("top_delivery");

        // List<String> keys = topDel.getBuckets()
        // .stream()
        // .map(b -> b.getKeyAsString());

        for (Map.Entry<String, Aggregation> entry : results.entrySet()) {
            System.out.println("RESULT ----->" + entry.getKey() + ":" + entry.getValue().toString());
            System.out.println(results.size());
        }

        // System.out.println("RESULT ---->" + results.entrySet());

        return new ArrayList<User>();
    }

}
