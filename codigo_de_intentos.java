// SearchRequest searchRequest = new SearchRequest("purchase");
    // List<BucketOrder> bucketOrderList = new ArrayList<>();
    // bucketOrderList.add(BucketOrder.aggregation("_count", true));
    // SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder().size(0);
    // searchSourceBuilder
    // .aggregation(AggregationBuilders.terms("purchase").field("deliveryMethod").order(bucketOrderList));
    // searchRequest.source(searchSourceBuilder);
    // SearchResponse res1 = client.search(searchRequest, RequestOptions.DEFAULT);
    // Terms terms = res1.getAggregations().get("purchase");
    // System.out.println(terms);

// return deliveryMethodRepository.findByName(terms.getBuckets().get(0).getKeyAsString()).get();

    // SearchRequest searchRequest = new SearchRequest("purchase");
    // SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

    // // // searchSourceBuilder.query(query);
    // searchSourceBuilder.aggregation(AggregationBuilders.count("delivery_method")).from(0).size(1);
    // searchRequest.source(searchSourceBuilder);

    // SearchResponse response = client.search(searchRequest,
    // RequestOptions.DEFAULT);
    // SearchHit[] hits = response.getHits().getHits();
    // for (SearchHit hit : hits) {
    // System.out.println(hit.getSourceAsString());
    // }

    // Query query = new NativeSearchQueryBuilder()
    // .addAggregation(AggregationBuilders.count("deliveryMethod").field("deliveryMethod")).build();
    // ElasticsearchRestTemplate template = new ElasticsearchRestTemplate(client);
    // List<DeliveryMethod> searchHits = template.search(query,
    // DeliveryMethod.class).map(SearchHit::getContent).toList();
    // System.out.println("RESULTADO ------>>>>>" + searchHits);

    // return new DeliveryMethod();
