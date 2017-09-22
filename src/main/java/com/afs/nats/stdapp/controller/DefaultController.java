package com.afs.nats.stdapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {
	@GetMapping("/base")
	public String getBase() {
		return "layouts/base";
	}

	@GetMapping("/default")
	public String getDefault() {
		return "layouts/default";
	}
}
