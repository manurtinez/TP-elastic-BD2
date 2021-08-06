package manu.pruebaelastic.repositories;

import manu.pruebaelastic.model.Author;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends ElasticsearchRepository<Author, String> {

    List<Author> findAll();

    Author findByName(String name);

}