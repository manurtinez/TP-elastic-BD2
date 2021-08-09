package manu.pruebaelastic.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import manu.pruebaelastic.model.Purchase;
import manu.pruebaelastic.model.User;
import manu.pruebaelastic.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping()
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping
    public User createUser(@RequestBody User user) {
        return this.userService.addUser(user);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping("/{userid}/purchases")
    public void addPurchase(@PathVariable String userid, @RequestBody Purchase purchase) {
        // Agrego el purchase al array del user
        User user = userService.findById(userid);

        userService.addPurchaseToUser(user, purchase);
    }
}
