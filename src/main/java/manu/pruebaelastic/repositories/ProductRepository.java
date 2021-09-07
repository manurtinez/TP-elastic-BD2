package manu.pruebaelastic.repositories;

import java.util.List;

import manu.pruebaelastic.model.Purchase;
import manu.pruebaelastic.repositories.custom.CustomProductRepository;
import manu.pruebaelastic.repositories.custom.CustomPurchaseRepository;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import manu.pruebaelastic.model.Product;

public interface ProductRepository extends ElasticsearchRepository<Product, String>, CustomProductRepository {
  List<Product> findAll();

}
