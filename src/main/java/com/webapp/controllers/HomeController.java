package com.webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// Un comentario más.
// Comentario creado desde VSC.
@Controller
@RequestMapping("/")
public class HomeController {

	@GetMapping
	public String index(ModelMap model) {
		return "index";
	}

	public void doNothing(){}

	public void foo(){}
	public void foo1(){}
	public void foo2(){}
}
