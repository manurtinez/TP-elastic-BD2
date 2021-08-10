package manu.pruebaelastic.repositories;

import java.util.Optional;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import manu.pruebaelastic.model.DeliveryMethod;

public interface DeliveryMethodRepository extends ElasticsearchRepository<DeliveryMethod, String> {
  // Asumiré que solo pueda haber uno con el mismo nombre
  Optional<DeliveryMethod> findByName(String name);
}
