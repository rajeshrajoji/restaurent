package com.charlie.online.foodchain.controller;

import com.charlie.online.foodchain.dto.UserCartItem;
import com.charlie.online.foodchain.entities.CartItem;
import com.charlie.online.foodchain.entities.MenuItem;
import com.charlie.online.foodchain.services.CustomerCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("cart")
public class CustomerCartController {

    @Autowired
    CustomerCartService customerCartService;

    @CrossOrigin
    @RequestMapping(value = "/itemAdd", method = RequestMethod.POST)
    public Set<CartItem> itemAdd(@RequestBody UserCartItem userCartItem) {
        return customerCartService.saveCartItem(userCartItem);
    }


    @CrossOrigin
    @RequestMapping(value = "/items/{userId}", method = RequestMethod.GET)
    public Set<CartItem> itemAdd(@PathVariable String  userId) {
        return customerCartService.getCartItems(userId);
    }




}
