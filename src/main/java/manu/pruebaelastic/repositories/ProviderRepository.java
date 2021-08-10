package manu.pruebaelastic.repositories;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import manu.pruebaelastic.model.Provider;

@Repository
public interface ProviderRepository extends ElasticsearchRepository<Provider, String> {

  List<Provider> findAll();

  List<Provider> findByCuit(Long cuit);

}