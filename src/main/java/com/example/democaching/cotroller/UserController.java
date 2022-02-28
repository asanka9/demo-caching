package com.example.democaching.cotroller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.democaching.model.User;
import com.example.democaching.repo.UserRepo;
import com.example.democaching.service.UserServiceImpl;

@Controller
@RequestMapping("/")
public class UserController {
	
	
	@Autowired
	UserServiceImpl service;
	
    @GetMapping("/")
    public String viewHomePage() {
        return "index";
    }
    
    @PostMapping("/")
    public String registerUser(User user) {
    	service.registerUser(user);
    	return "index";
    }
    
    
    @PostMapping("/profile")
    public String userProfile(@RequestParam("email") String email,@RequestParam("password") String password,Model model) {
    	if (service.loginUser(email, password)) {
    		model.addAttribute("user",service.getUserData(email));
			return "profile";
		} else {
			return "redirect:";
		}
    	
    }
    
    
    

}
