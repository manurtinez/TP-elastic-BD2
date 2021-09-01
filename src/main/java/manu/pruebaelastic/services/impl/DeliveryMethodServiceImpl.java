package manu.pruebaelastic.services.impl;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import manu.pruebaelastic.model.DeliveryMethod;
import manu.pruebaelastic.repositories.DeliveryMethodRepository;
import manu.pruebaelastic.services.DeliveryMethodService;

@Service
public class DeliveryMethodServiceImpl implements DeliveryMethodService {

  @Autowired
  private DeliveryMethodRepository deliveryMethodRepository;

  public DeliveryMethodServiceImpl(DeliveryMethodRepository deliveryMethodRepository) {
    this.deliveryMethodRepository = deliveryMethodRepository;
  }

  @Override
  public Optional<DeliveryMethod> findByName(String name) {
    return deliveryMethodRepository.findByName(name);
  }

  // Si existe uno con el mismo nombre, retorna ese, sino lo crea
  @Override
  public DeliveryMethod createOrGetDeliveryMethod(DeliveryMethod aDeliveryMethod) {
    Optional<DeliveryMethod> retrievedDM = deliveryMethodRepository.findByName(aDeliveryMethod.getName());
    if (!retrievedDM.isPresent()) {
      return deliveryMethodRepository.save(aDeliveryMethod);
    } else {
      return retrievedDM.get();
    }
  }

  public DeliveryMethod getMostUsedDeliveryMethod() throws IOException {
    // El getMostUsedDeliveryMethod devuelve solo el nombre. Se hace un findByName
    // para devolver el objeto.
    return deliveryMethodRepository.findByName(deliveryMethodRepository.getMostUsedDeliveryMethod()).get();
  }
}
