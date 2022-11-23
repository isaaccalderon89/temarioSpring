package com.ite.saludo.controlador;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@GetMapping("/saludo")
	public String bienvenida() {
	
		return "Bienvenido al curso de Spring boot";
	}

}
