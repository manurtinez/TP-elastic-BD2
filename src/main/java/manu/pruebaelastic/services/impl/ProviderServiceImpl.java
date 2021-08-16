package manu.pruebaelastic.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import manu.pruebaelastic.model.Provider;
import manu.pruebaelastic.model.ProductOnSale;
import manu.pruebaelastic.repositories.ProviderRepository;
import manu.pruebaelastic.services.ProviderService;

@Service
public class ProviderServiceImpl implements ProviderService {

    @Autowired
    private final ProviderRepository providerRepository;

    public ProviderServiceImpl(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    @Override
    public Provider addProvider(Provider provider) {
        Provider newProv = new Provider(provider.getName(), provider.getCuit());
        return providerRepository.save(newProv);
    }

    public List<Provider> findAll() {
        return providerRepository.findAll();
    }

    @Override
    public Provider findById(String id) {
        //System.out.println(id);
        return providerRepository.findById(id).get();
    }
    
    @Override
    public void addProductOnSaleToProvider(Provider prov, ProductOnSale pos) {
        prov.addProductOnSale(pos);
        providerRepository.save(prov);
    }

}
