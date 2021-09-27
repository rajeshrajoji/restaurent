package com.charlie.online.foodchain.dao;

import com.charlie.online.foodchain.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author kamal berriga
 *
 */
/* this the user  Repository interface  */ 
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

public User findByUsername(String username);

public User findOneByUsernameAndPassword(String userName, String password);


}
