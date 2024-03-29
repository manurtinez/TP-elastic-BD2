package manu.pruebaelastic.services;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import manu.pruebaelastic.model.Purchase;

public interface PurchaseService {
  List<Purchase> getAll();

  Purchase createPurchase(Purchase pur);

  List<Purchase> getPurchasesInPeriod(Date start, Date end) throws IOException;
}
