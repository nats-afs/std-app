package com.afs.nats.stdapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
// @RequestMapping("/login")
public class LoginController {

	@GetMapping("/login")
	public String login() {
		return "login";
	}

//	@GetMapping("/login-error")
//	public String loginError(Model model) {
//		model.addAttribute("loginError", true);
//		return "login";
//	}
//	@PostMapping
//	public String loginProcess() {
//		return "error";
//	}
}
