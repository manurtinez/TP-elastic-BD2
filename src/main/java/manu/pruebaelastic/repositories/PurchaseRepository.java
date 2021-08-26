package manu.pruebaelastic.repositories;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import manu.pruebaelastic.model.Purchase;
import manu.pruebaelastic.repositories.custom.CustomPurchaseRepository;

public interface PurchaseRepository extends ElasticsearchRepository<Purchase, String>, CustomPurchaseRepository {
  List<Purchase> findAll();
}
