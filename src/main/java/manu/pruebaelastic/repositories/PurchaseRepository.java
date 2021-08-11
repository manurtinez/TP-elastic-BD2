package manu.pruebaelastic.repositories;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import manu.pruebaelastic.model.Purchase;

public interface PurchaseRepository extends ElasticsearchRepository<Purchase, String> {
  List<Purchase> findAll();
}
