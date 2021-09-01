package manu.pruebaelastic.repositories.custom;

import java.io.IOException;

public interface CustomDeliveryMethodRepository {
  String getMostUsedDeliveryMethod() throws IOException;
}
