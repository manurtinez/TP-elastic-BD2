package manu.pruebaelastic.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import manu.pruebaelastic.model.Product;
import manu.pruebaelastic.repositories.ProductRepository;
import manu.pruebaelastic.services.CategoryService;
import manu.pruebaelastic.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private CategoryService categoryService;

  ProductServiceImpl(ProductRepository productRepository, CategoryService categoryService) {
    this.productRepository = productRepository;
    this.categoryService = categoryService;
  }

  @Override
  public List<Product> findAll() {
    return productRepository.findAll();
  }

  @Override
  public Product createProduct(Product prod) {
    // Si la categoria no existe, crearla y asignarla
    prod.setCategory(categoryService.createOrGetCategory(prod.getCategory()));

    // Agregar producto al array de la category (??)
    // categoryService.addProductToCategory(prod.getCategory(), prod);

    return productRepository.save(prod);
  }

}
