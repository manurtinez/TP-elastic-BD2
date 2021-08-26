package manu.pruebaelastic.repositories.custom;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import manu.pruebaelastic.model.Purchase;

public interface CustomPurchaseRepository {
  List<Purchase> getPurchasesInPeriod(Date start, Date end) throws IOException;
}
