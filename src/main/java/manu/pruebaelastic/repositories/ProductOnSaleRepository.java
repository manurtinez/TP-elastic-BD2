package manu.pruebaelastic.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import manu.pruebaelastic.model.ProductOnSale;

@Repository
public interface ProductOnSaleRepository extends ElasticsearchRepository<ProductOnSale, String> {
  List<ProductOnSale> findAll();

}