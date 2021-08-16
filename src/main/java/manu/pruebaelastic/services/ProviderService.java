package manu.pruebaelastic.services;

import java.util.List;

import manu.pruebaelastic.model.Provider;
import manu.pruebaelastic.model.ProductOnSale;

public interface ProviderService {
    List<Provider> findAll();

    Provider findById(String id);

    Provider addProvider(Provider provider);
    
    void addProductOnSaleToProvider(Provider prov, ProductOnSale pos);

}