package com.afs.nats.stdapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	@GetMapping({ "/", "/home", "/homepage", "index" })
	public String home() {
		return "index";
	}
}
