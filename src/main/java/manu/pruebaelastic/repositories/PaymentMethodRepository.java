package manu.pruebaelastic.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import manu.pruebaelastic.model.PaymentMethod;

@Repository
public interface PaymentMethodRepository extends ElasticsearchRepository<PaymentMethod, String> {
  List<PaymentMethod> findAll();

  Optional<PaymentMethod> findByName(String name);
}
