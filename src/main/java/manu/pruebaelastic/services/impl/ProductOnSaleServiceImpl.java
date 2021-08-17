package manu.pruebaelastic.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import manu.pruebaelastic.model.ProductOnSale;
import manu.pruebaelastic.model.Product;
import manu.pruebaelastic.repositories.ProductOnSaleRepository;
import manu.pruebaelastic.services.ProductOnSaleService;

@Service
public class ProductOnSaleServiceImpl implements ProductOnSaleService {

    @Autowired
    private final ProductOnSaleRepository productOnSaleRepository;

    public ProductOnSaleServiceImpl(ProductOnSaleRepository productOnSaleRepository) {
        this.productOnSaleRepository = productOnSaleRepository;
    }

    @Override
    public ProductOnSale addProductOnSale(ProductOnSale productOnSale) {
    	ProductOnSale newPos = new ProductOnSale(productOnSale.getPrice(), productOnSale.getInitialDate());
        return productOnSaleRepository.save(newPos);
    }

    public List<ProductOnSale> findAll() {
        return productOnSaleRepository.findAll();
    }
    
    public void addProductToProductOnSale(ProductOnSale pos, Product prod) {
        pos.addProduct(prod);
        productOnSaleRepository.save(pos);
    }
    
    public ProductOnSale findById(String id) {
        return productOnSaleRepository.findById(id).get();
    }

}
