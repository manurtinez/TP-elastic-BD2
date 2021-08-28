package manu.pruebaelastic.services;

import java.util.List;

import manu.pruebaelastic.model.Purchase;
import manu.pruebaelastic.model.User;

public interface UserService {
    List<User> findAll();

    User findById(String id);

    User addUser(User user);

    void addPurchaseToUser(User user, Purchase pur);
}
