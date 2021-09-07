package manu.pruebaelastic.repositories.custom;

import manu.pruebaelastic.model.Category;
import manu.pruebaelastic.model.Product;

import java.io.IOException;
import java.util.List;

public interface CustomProductRepository {
    List<Product> getProductsForCategory(Category cat) throws IOException;
}
