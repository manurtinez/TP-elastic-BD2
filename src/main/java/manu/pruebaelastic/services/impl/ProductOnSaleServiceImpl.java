package manu.pruebaelastic.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import manu.pruebaelastic.model.ProductOnSale;
import manu.pruebaelastic.model.DTO.ProductOnSaleDTO;
import manu.pruebaelastic.model.Product;
import manu.pruebaelastic.repositories.ProductOnSaleRepository;
import manu.pruebaelastic.repositories.ProductRepository;
import manu.pruebaelastic.services.ProductOnSaleService;

@Service
public class ProductOnSaleServiceImpl implements ProductOnSaleService {

    @Autowired
    private final ProductOnSaleRepository productOnSaleRepository;

    @Autowired
    private final ProductRepository productRepository;

    public ProductOnSaleServiceImpl(ProductOnSaleRepository productOnSaleRepository,
            ProductRepository productRepository) {
        this.productOnSaleRepository = productOnSaleRepository;
        this.productRepository = productRepository;
    }

    @Override
    public ProductOnSale addProductOnSale(ProductOnSaleDTO productOnSaleDTO) {
        Product prod = productRepository.findById(productOnSaleDTO.getProduct()).get();
        ProductOnSale newPos = new ProductOnSale(prod, productOnSaleDTO.getPrice(), productOnSaleDTO.getInitialDate());
        return productOnSaleRepository.save(newPos);
    }

    public List<ProductOnSale> findAll() {
        return productOnSaleRepository.findAll();
    }

    // TODO Este metodo no va mas
    // public void addProductToProductOnSale(ProductOnSale pos, Product prod) {
    // productOnSaleRepository.save(pos);
    // }

    public ProductOnSale findById(String id) {
        return productOnSaleRepository.findById(id).get();
    }

}
