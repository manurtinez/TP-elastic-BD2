package manu.pruebaelastic.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import manu.pruebaelastic.model.ProductOnSale;
import manu.pruebaelastic.services.ProductOnSaleService;

@RestController
@RequestMapping("/productonsale")
public class ProductOnSaleController {

    private final ProductOnSaleService productOnSaleService;

    public ProductOnSaleController(ProductOnSaleService productOnSaleService) {
        this.productOnSaleService = productOnSaleService;
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

}