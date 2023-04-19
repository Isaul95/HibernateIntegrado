package com.mx.mex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping(value = "con")
public class LoginController { //Este controlador sin nombre
	
	
	@RequestMapping(value = "/Login") // Este > "/Login" se manda a llamar desde el index.jsp, y se usa para rideccionar archivo login,jsp
	public String Login() {
		//model.addAttribute("Bienvenida", "¡Bienvenido!");//HACIENDO USO DEL OBJETO MODEL

		return "Login"; // Login --> Es el archivo Login,jsp que se encuentra en la ruta WEB-INF/Views
	}
		
	@RequestMapping(value = "/Inicio") // Este servicio es para mostrar la pagina
	public String Inicio() {

		return "Inicio";
	}
		
}
