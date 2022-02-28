package com.example.democaching.service;

import com.example.democaching.model.User;

public interface UserService {
	
	public boolean registerUser(User user);
	
	public boolean loginUser(String email,String password);
	
	public User getUserData(String email);

}
