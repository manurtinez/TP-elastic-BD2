package manu.pruebaelastic.services;

import java.util.List;

import manu.pruebaelastic.model.ProductOnSale;
import manu.pruebaelastic.model.DTO.ProductOnSaleDTO;
import manu.pruebaelastic.model.Product;

public interface ProductOnSaleService {
  List<ProductOnSale> findAll();

  ProductOnSale findById(String id);

  ProductOnSale addProductOnSale(ProductOnSaleDTO productOnSaleDTO);

  // TODO este metodo no va mas
  // void addProductToProductOnSale(ProductOnSale pos, Product prod);
}