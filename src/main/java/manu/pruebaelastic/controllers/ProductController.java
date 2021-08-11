package manu.pruebaelastic.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import manu.pruebaelastic.model.Product;
import manu.pruebaelastic.services.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

  private final ProductService productService;

  ProductController(ProductService productService) {
    this.productService = productService;
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping()
  public List<Product> getAllProducts() {
    return productService.findAll();
  }

  @ResponseStatus(HttpStatus.ACCEPTED)
  @PostMapping()
  public Product createProduct(@RequestBody Product prod) {
    return productService.createProduct(prod);
  }
}
