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
import manu.pruebaelastic.services.DeliveryMethodService;
import manu.pruebaelastic.services.PaymentMethodService;
import manu.pruebaelastic.services.PurchaseService;
import manu.pruebaelastic.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    private final PurchaseService purchaseService;

    private final DeliveryMethodService deliveryMethodService;

    private final PaymentMethodService paymentMethodService;

    public UserController(UserService userService, PurchaseService purchaseService,
            DeliveryMethodService deliveryMethodService, PaymentMethodService paymentMethodService) {
        this.userService = userService;
        this.purchaseService = purchaseService;
        this.deliveryMethodService = deliveryMethodService;
        this.paymentMethodService = paymentMethodService;
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
        // Creo la purchase (y si no existe, el delivery y payment method también) en la
        // db
        purchase.setDeliveryMethod(deliveryMethodService.createOrGetDeliveryMethod(purchase.getDeliveryMethod()));
        purchase.setPaymentMethod(paymentMethodService.createOrGetPaymentMethod(purchase.getPaymentMethod()));
        Purchase createdPurchase = purchaseService.createPurchase(purchase);

        // Agrego el purchase al array del user
        User user = userService.findById(userid);
        userService.addPurchaseToUser(user, createdPurchase);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{userid}/purchases")
    public List<Purchase> getAllPurchasesMadeByUser(@PathVariable String userid) {
        User user = userService.findById(userid);
        return user.getPurchases();
    }
}
