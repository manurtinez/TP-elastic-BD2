package manu.pruebaelastic.repositories;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import manu.pruebaelastic.model.Product;

public interface ProductRepository extends ElasticsearchRepository<Product, String> {
  List<Product> findAll();

}
