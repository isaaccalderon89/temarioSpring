package com.ite.productos.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ite.productos.modelo.beans.Producto;
import com.ite.productos.modelo.repository.IntProductos;

@Controller
public class HomeController {
	@Autowired
	private IntProductos iprod;
	
	@GetMapping("/inicio")
	public String inicio(Model model) {
		
		for (Producto ele: iprod.findAll())
			System.out.println(ele);
		
		model.addAttribute("listaProductos", iprod.findAll());
		return "index";
	}

}
