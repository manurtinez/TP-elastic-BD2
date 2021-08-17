package manu.pruebaelastic.services;

import java.util.List;

import manu.pruebaelastic.model.ProductOnSale;
import manu.pruebaelastic.model.User;
import manu.pruebaelastic.model.Product;

public interface ProductOnSaleService {
  List<ProductOnSale> findAll();
  
  ProductOnSale findById(String id);

  ProductOnSale addProductOnSale(ProductOnSale productOnSale);
  
  void addProductToProductOnSale(ProductOnSale pos, Product prod);
}