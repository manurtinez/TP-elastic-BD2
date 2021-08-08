package manu.pruebaelastic.services;

import java.util.List;

import manu.pruebaelastic.model.User;

public interface UserService {
    List<User> findAll();

    User findById(String id);

    User addUser(User user);

    // void addArticleToUser(String id, Article article);
}
