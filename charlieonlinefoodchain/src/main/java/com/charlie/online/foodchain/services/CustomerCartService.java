package com.charlie.online.foodchain.services;

import com.charlie.online.foodchain.dao.CustomerCartRepository;
import com.charlie.online.foodchain.dao.MenuItemRepository;
import com.charlie.online.foodchain.dao.UserRepository;
import com.charlie.online.foodchain.dto.UserCartItem;
import com.charlie.online.foodchain.entities.CartItem;
import com.charlie.online.foodchain.entities.MenuItem;
import com.charlie.online.foodchain.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CustomerCartService {

    @Autowired
    private CustomerCartRepository customerCartRepository;

    @Autowired
    private MenuItemRepository menuItemRepository;

    @Autowired
    private UserRepository userRepository;

    public Set<CartItem> saveCartItem(UserCartItem item) {

        Optional<MenuItem> menuItemOptional = menuItemRepository.findById(item.getMenuItemId());
        User user= userRepository.findByUsername(item.getUser().getUsername());

        if(menuItemOptional.isPresent()) {
            MenuItem menuItem = menuItemOptional.get();
            CartItem cartItem = new CartItem();
            cartItem.setName(menuItem.getName());
            cartItem.setPrice(menuItem.getPrice());
            cartItem.setType(menuItem.getType());
            cartItem.setUser(user);
            cartItem.setQuantity(item.getQuantity());
            customerCartRepository.save(cartItem);
        }
        return user.getCartItems();
    }

    public Set<CartItem> getCartItems(String userId) {
        Optional<User> user= userRepository.findById(Long.valueOf(userId));
        if(user.isPresent()) {
            User userData = user.get();
            return userData.getCartItems();
        }
        return null;
    }
}
