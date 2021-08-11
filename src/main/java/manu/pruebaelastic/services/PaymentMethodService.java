package manu.pruebaelastic.services;

import java.util.List;

import manu.pruebaelastic.model.PaymentMethod;

public interface PaymentMethodService {
  List<PaymentMethod> getAll();

  PaymentMethod createOrGetPaymentMethod(PaymentMethod pm);
}
