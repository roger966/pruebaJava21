/**
 * 
 */
package com.example.proyectoPrueba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.proyectoPrueba.model.DTO.ResultadoDTO;
import com.example.proyectoPrueba.model.entity.NivelContrasena;
import com.example.proyectoPrueba.service.i.INivelContrasenaService;

/**
 * <b>Descripción:</b> Clase UsuarioController que contiene todo el proceso de controller para garantizar el registro de un usuario
 * @author roger
 *
 */
@RestController
@RequestMapping("/configuraContrasenas")
public class NivelContrasenaController {

	@Autowired
	private INivelContrasenaService iNivelContrasenaService;
	
	/**
	 * <b>Descripción:</b> Método que contiene toda la lógica necesaria para realizar su debido proceso de registro de una contraseña
	 * @param dato corresponde a los datos de configuración de la contraseña
	 * @author roger
	 *
	 */
	@PostMapping("/guardaContrasena")
    public ResultadoDTO registrarUsuario(@RequestBody String dato) {
		return iNivelContrasenaService.guardarConfiguracionContrasena(dato);
    }
	
	/**
	 * <b>Descripción:</b> Método que contiene toda la lógica necesaria para realizar su debido proceso de consulta de una contraseña
	 * @author roger
	 *
	 */
	@GetMapping("/consultaContrasena")
	public List<NivelContrasena> consultarUsuarios(){
		return iNivelContrasenaService.consultarConfiguracion();
	}
}
