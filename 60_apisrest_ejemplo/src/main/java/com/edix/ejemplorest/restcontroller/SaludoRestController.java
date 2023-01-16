package com.edix.ejemplorest.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edix.ejemplorest.Contacto;

@RestController
@RequestMapping("/rest/saludo")
public class SaludoRestController {
	
	@GetMapping("/hola")
	public String saludar() {
		return "Hola me llamo Isaac \nEsto es un String (un dato) no un HTML";
	}
	
	@GetMapping("/contacto")
	public Contacto contacto() {
		return new Contacto("Isaac", "625975190", "isaaccalderon89@gmail.com");
	}
}
