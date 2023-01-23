package com.example.les21.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.les21.domain.User;
import com.example.les21.service.UserService;

@Controller
public class AuthController {
	@Autowired
	private UserService userService;

	@GetMapping("/index")
	public String home() {
		return "index";
	}
	@GetMapping("/register")
	public String showRegisterForm(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "register";
	}
	@PostMapping("/register/save")
	public String registration(@Validated @ModelAttribute("user")User user, BindingResult result, Model model) {
		User existingUser = userService.findUserByEmail(user.getEmail());
		if (existingUser!=null && existingUser.getEmail()!=null&&!existingUser.getEmail().isEmpty()) {
			result.rejectValue("email", null,"There is already an account registered with the same email");
		}
		if (result.hasErrors()) {
			model.addAttribute("user",user);
			return "/register";
		}
		userService.saveUser(user);
		return "redirect:/register?success";
	}
	 @GetMapping("/login")
	    public String login(){
	        return "login";
	    }
}
