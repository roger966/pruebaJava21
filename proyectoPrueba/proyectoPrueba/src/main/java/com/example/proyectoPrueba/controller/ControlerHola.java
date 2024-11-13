/**
 * 
 */
package com.example.proyectoPrueba.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 */
@RestController
@RequestMapping("/usuarios")
public class ControlerHola {
	
	@GetMapping("/consulta")
	public String consultarUsuarios(){
		return "Hola Soy un usuario ;)";
	}

}
