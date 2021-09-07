package manu.pruebaelastic.controllers;

import java.io.IOException;
import java.util.List;

import manu.pruebaelastic.model.Product;
import manu.pruebaelastic.model.Purchase;
import manu.pruebaelastic.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import manu.pruebaelastic.model.Category;
import manu.pruebaelastic.services.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

  private final CategoryService categoryService;
  private final ProductService productService;

  public CategoryController(CategoryService categoryService, ProductService productService) {
    this.categoryService = categoryService;
    this.productService = productService;
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping()
  public List<Category> getAllCategories() {
    return categoryService.findAll();
  }

  @ResponseStatus(HttpStatus.ACCEPTED)
  @PostMapping
  public Category createCategory(@RequestBody Category category) {
    return this.categoryService.createOrGetCategory(category);
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping("/less-products")
  public Category getCategoryWithLessProducts() throws IOException {
    return this.categoryService.getCategoryWithLessProducts();
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping("/{categoryName}/products")
  public List<Product> getProductForCategory(@PathVariable String categoryName) throws IOException {
    Category category = this.categoryService.findByName(categoryName);
    return this.productService.getProductsForCategory(category);
  }
}
