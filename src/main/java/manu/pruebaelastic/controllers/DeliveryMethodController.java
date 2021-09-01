package manu.pruebaelastic.controllers;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import manu.pruebaelastic.model.DeliveryMethod;
import manu.pruebaelastic.services.DeliveryMethodService;

@RestController
@RequestMapping("/delivery")
public class DeliveryMethodController {
  private final DeliveryMethodService deliveryMethodService;

  public DeliveryMethodController(DeliveryMethodService deliveryMethodService) {
    this.deliveryMethodService = deliveryMethodService;
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping("/most-used")
  public DeliveryMethod getMostUsedDeliveryMethod() throws IOException {
    return deliveryMethodService.getMostUsedDeliveryMethod();
  }
}
