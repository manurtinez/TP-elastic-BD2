package manu.pruebaelastic.services;

import java.util.List;

import manu.pruebaelastic.model.Provider;

public interface ProviderService {
    List<Provider> findAll();

    Provider findById(String id);

    Provider addProvider(Provider provider);

}