package manu.pruebaelastic.repositories.custom;

import java.io.IOException;

public interface CustomCategoryRepository {
  String getCategoryWithLessProducts() throws IOException;
}
