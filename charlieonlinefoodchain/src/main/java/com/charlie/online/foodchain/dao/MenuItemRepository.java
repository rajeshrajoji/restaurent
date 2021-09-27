package com.charlie.online.foodchain.dao;


import com.charlie.online.foodchain.entities.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public
interface MenuItemRepository extends JpaRepository<MenuItem, Long> {

}