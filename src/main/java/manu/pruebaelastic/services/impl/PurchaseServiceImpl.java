package manu.pruebaelastic.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import manu.pruebaelastic.model.Purchase;
import manu.pruebaelastic.repositories.PurchaseRepository;
import manu.pruebaelastic.services.PurchaseService;

@Service
public class PurchaseServiceImpl implements PurchaseService {

  @Autowired
  private final PurchaseRepository purchaseRepository;

  public PurchaseServiceImpl(PurchaseRepository purchaseRepository) {
    this.purchaseRepository = purchaseRepository;
  }

  @Override
  public List<Purchase> getAll() {
    return purchaseRepository.findAll();
  }

  @Override
  public Purchase createPurchase(Purchase pur) {
    return purchaseRepository.save(pur);
  }

}
