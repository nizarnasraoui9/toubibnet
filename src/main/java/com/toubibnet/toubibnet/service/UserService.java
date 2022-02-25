package com.toubibnet.toubibnet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toubibnet.toubibnet.exception.UserNotFoundException;
import com.toubibnet.toubibnet.model.User;
import com.toubibnet.toubibnet.repository.UserRepo;

@Service
public class UserService {
	@Autowired
	UserRepo userRepo;
	
	public List<User> findAllUsers(){
		return this.userRepo.findAll();
	}
	public User findUserById(Long id) {
		return userRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
	}
	public User findUserByEmail(String email) {
		return userRepo.findByEmail(email);
	}

	public User addUser(User user) {
		return userRepo.save(user);	}
	
	public User updateUser(User user) {
		return userRepo.save(user);
	}
	
	public void deleteUser(Long id){
		userRepo.deleteById(id);
    }
}
