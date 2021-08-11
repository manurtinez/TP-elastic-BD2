package manu.pruebaelastic.services;

import java.util.List;

import manu.pruebaelastic.model.Purchase;

public interface PurchaseService {
  List<Purchase> getAll();

  Purchase createPurchase(Purchase pur);
}
