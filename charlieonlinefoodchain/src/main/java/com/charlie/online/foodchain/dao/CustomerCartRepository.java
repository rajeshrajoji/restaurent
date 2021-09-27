package com.charlie.online.foodchain.dao;

import com.charlie.online.foodchain.entities.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerCartRepository extends JpaRepository<CartItem, Long> {

}
