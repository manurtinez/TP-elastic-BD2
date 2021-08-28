package manu.pruebaelastic.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import manu.pruebaelastic.model.Provider;
import manu.pruebaelastic.model.DTO.ProductOnSaleDTO;
import manu.pruebaelastic.model.ProductOnSale;
import manu.pruebaelastic.services.ProviderService;
import manu.pruebaelastic.services.ProductOnSaleService;

@RestController
@RequestMapping("/provider")
public class ProviderController {

    private final ProviderService providerService;
    private final ProductOnSaleService productOnSaleService;

    public ProviderController(ProviderService providerService, ProductOnSaleService productOnSaleService) {
        this.providerService = providerService;
        this.productOnSaleService = productOnSaleService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping()
    public List<Provider> getAllProviders() {
        return providerService.findAll();
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping
    public Provider createProvider(@RequestBody Provider provider) {
        return this.providerService.addProvider(provider);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping("/{providerid}/productsonsale")
    public void addProductOnSale(@PathVariable String providerid, @RequestBody ProductOnSaleDTO productOnSaleDTO) {

        ProductOnSale createdProductOnSale = productOnSaleService.addProductOnSale(productOnSaleDTO);
        Provider provider = providerService.findById(providerid);
        providerService.addProductOnSaleToProvider(provider, createdProductOnSale);
    }

}
