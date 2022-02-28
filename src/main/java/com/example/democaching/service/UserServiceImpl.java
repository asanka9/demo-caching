package com.example.democaching.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.democaching.model.User;
import com.example.democaching.repo.UserRepo;


@Component
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo repo;
	
	@Override
	public boolean registerUser(User user) {
		// save User object
		return repo.save(user) != null;
	}

	@Override
	public boolean loginUser(String email, String password) {
		
		try {
			User user = repo.findByEmail(email);
			if (user.getPassword().equals(password)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		
		
	}

	@Override
	public User getUserData(String email) {
		User user = repo.findByEmail(email);
		return user;
	}

}
