package manu.pruebaelastic.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import manu.pruebaelastic.model.ProductOnSale;
import manu.pruebaelastic.model.Product;
import manu.pruebaelastic.services.ProductOnSaleService;
import manu.pruebaelastic.services.ProductService;

@RestController
@RequestMapping("/productonsale")
public class ProductOnSaleController {

    private final ProductOnSaleService productOnSaleService;
    private final ProductService productService;

    public ProductOnSaleController(ProductOnSaleService productOnSaleService, ProductService productService) {
        this.productOnSaleService = productOnSaleService;
        this.productService = productService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping()
    public List<ProductOnSale> getAllProductsOnSale() {
        return productOnSaleService.findAll();
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping
    public ProductOnSale createProductOnSale(@RequestBody ProductOnSale productOnSale) {
        return this.productOnSaleService.addProductOnSale(productOnSale);
    }
    
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping("/{productonsaleid}/product")
    public void addProduct(@PathVariable String productonsaleid, @RequestBody Product product) {
        
        Product createdProduct = productService.createProduct(product);
        ProductOnSale productonsale = productOnSaleService.findById(productonsaleid);
        productOnSaleService.addProductToProductOnSale(productonsale, createdProduct);
    }

}