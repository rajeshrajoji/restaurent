package com.charlie.online.foodchain.services;


import com.charlie.online.foodchain.entities.User;
import com.charlie.online.foodchain.dao.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author kamal berriga
 *
 */
@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	@Transactional
	public User save(User user) {
		
	   //System.out.println("**"+user.getCourses().size());
	   userRepository.saveAndFlush(user);
	  // if(!user.getCourses().isEmpty()) {
//		    Course c = new Course();
//
//		   // c.setId(user.getCourses().iterator().next().getId());
//		    Course cc = courseRepo.findOne((user.getCourses().iterator().next().getId()));
//		    c.setName(cc.getName());
//		    c.setId(cc.getId());
//		    c.getUsers().add(user);
//	 		courseService.saveCourse(c);
	  // }
	   return user;
	}

	public User update(User user) {
		return userRepository.save(user);
	}

	public User find(String userName) {
		return userRepository.findByUsername(userName);
	}

	public User findByCredentials(String userName, String password) {
		return userRepository.findOneByUsernameAndPassword(userName, password);
	}

	//public User find(Long id) {
	//	return userRepository.findOne(id);
	//}
}
