package manu.pruebaelastic.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import manu.pruebaelastic.model.DTO.PeriodDTO;
import manu.pruebaelastic.model.Purchase;
import manu.pruebaelastic.services.PurchaseService;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

  private final PurchaseService purchaseService;

  public PurchaseController(PurchaseService purchaseService) {
    this.purchaseService = purchaseService;
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping()
  public List<Purchase> getAllPurchases() {
    return purchaseService.getAll();
  }

  @ResponseStatus(HttpStatus.ACCEPTED)
  @PostMapping
  public Purchase createPurchase(@RequestBody Purchase purchase) {
    return this.purchaseService.createPurchase(purchase);
  }

  @PostMapping("/in-period")
  public List<Purchase> getPurchasesInPeriod(@RequestBody PeriodDTO period) throws IOException {
    return this.purchaseService.getPurchasesInPeriod(period.getStart(), period.getEnd());
  }
}
