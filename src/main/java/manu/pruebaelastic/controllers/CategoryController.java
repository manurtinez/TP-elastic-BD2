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

import manu.pruebaelastic.model.Category;
import manu.pruebaelastic.services.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

  private final CategoryService categoryService;

  public CategoryController(CategoryService categoryService) {
    this.categoryService = categoryService;
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
}
