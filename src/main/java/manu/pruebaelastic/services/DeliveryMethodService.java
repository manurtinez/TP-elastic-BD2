package manu.pruebaelastic.services;

import java.util.Optional;

import manu.pruebaelastic.model.DeliveryMethod;

public interface DeliveryMethodService {
  Optional<DeliveryMethod> findByName(String name);

  DeliveryMethod createOrGetDeliveryMethod(DeliveryMethod aDeliveryMethod);
}
