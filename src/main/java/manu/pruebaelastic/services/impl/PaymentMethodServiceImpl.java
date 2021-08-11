package manu.pruebaelastic.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import manu.pruebaelastic.model.PaymentMethod;
import manu.pruebaelastic.repositories.PaymentMethodRepository;
import manu.pruebaelastic.services.PaymentMethodService;

@Service
public class PaymentMethodServiceImpl implements PaymentMethodService {

  @Autowired
  private PaymentMethodRepository paymentMethodRepository;

  PaymentMethodServiceImpl(PaymentMethodRepository paymentMethodRepository) {
    this.paymentMethodRepository = paymentMethodRepository;
  }

  @Override
  public List<PaymentMethod> getAll() {
    return paymentMethodRepository.findAll();
  }

  @Override
  public PaymentMethod createOrGetPaymentMethod(PaymentMethod pm) {
    Optional<PaymentMethod> retrievedPM = paymentMethodRepository.findByName(pm.getName());
    if (!retrievedPM.isPresent()) {
      // Según que tipo de payment sea, creo el que corresponda
      PaymentMethod newPM = (pm.getPaymentType().equals("OnDeliveryPayment"))
          ? new PaymentMethod(pm.getName(), pm.getPaymentType(), pm.getPromisedAmount()) // OnDeliveryPayment
          : new PaymentMethod(pm.getName(), pm.getPaymentType(), pm.getBrand(), pm.getNumber(), pm.getCvv(),
              pm.getOwner(), pm.getExpiry()); // CreditCardPayment
      return paymentMethodRepository.save(newPM);

    } else {
      return retrievedPM.get();
    }
  }

}
