package manu.pruebaelastic.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import manu.pruebaelastic.model.User;
import manu.pruebaelastic.repositories.UserRepository;
import manu.pruebaelastic.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User addUser(User user) {
        User newUser = new User(user.getEmail(), user.getFullName(), user.getPassword(), user.getDayOfBirth());
        return userRepository.save(newUser);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    // @Override
    // public void addArticleToUser(String id, Article article) {
    // User user = userRepository.findById(id).get();
    // user.addArticle(article);
    // userRepository.save(user);
    // }

    @Override
    public User findById(String id) {
        return userRepository.findById(id).get();
    }

}
