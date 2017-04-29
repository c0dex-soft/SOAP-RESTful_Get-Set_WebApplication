package com.purplemagic.ws.client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.purplemagic.ws.generated.Customer;


@Controller
public class HomeController {

	@RequestMapping("/")
	public String showHome(Model model) {
		model.addAttribute("customer", new Customer());
		return "home";
	}
}
