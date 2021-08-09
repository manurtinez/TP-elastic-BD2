package manu.pruebaelastic.repositories;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import manu.pruebaelastic.model.Purchase;

public interface PurchaseRepository extends ElasticsearchRepository<Purchase, String> {

}
