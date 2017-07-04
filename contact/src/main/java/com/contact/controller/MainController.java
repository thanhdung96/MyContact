package com.contact.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.contact.domain.User;
import com.contact.service.UserServiceImpl;

@Controller
public class MainController {
	@Autowired
	UserServiceImpl userService;

	@GetMapping("/contact/403")
	public String accessDenied(){
		return "403";
	}
	
	@GetMapping("/")
	public String init() {
		return "redirect:/contact";
	}

	@GetMapping("/login")
	public String getLogin() {
		return "login";
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse respond) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, respond, auth);
		}

		return "redirect:/login";
	}

	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("user", new User());

		return "register";
	}

	@PostMapping("/register/save")
	public String saveRegister(@Valid User user, BindingResult result,
			RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return "register";
		}

		userService.save(user);
		redirect.addFlashAttribute("registerOK", "Created new account");
		return "redirect:/login";
	}
}