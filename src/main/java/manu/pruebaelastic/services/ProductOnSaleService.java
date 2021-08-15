package manu.pruebaelastic.services;

import java.util.List;

import manu.pruebaelastic.model.ProductOnSale;
import manu.pruebaelastic.model.Provider;

public interface ProductOnSaleService {
  List<ProductOnSale> findAll();

  ProductOnSale addProductOnSale(ProductOnSale productOnSale);
}