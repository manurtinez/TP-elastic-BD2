package manu.pruebaelastic.repositories;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import manu.pruebaelastic.model.User;

@Repository
public interface UserRepository extends ElasticsearchRepository<User, String> {

  List<User> findAll();

  User findByEmail(String email);
}
