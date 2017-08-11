package com.afs.nats.stdapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
	@RequestMapping(value = { "/", "/home", "/homepage", "index" }, method = RequestMethod.GET)
	public String home() {
		return "index";
	}
}
