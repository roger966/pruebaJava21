/**
 * 
 */
package com.example.proyectoPrueba.service.i;

import java.util.List;

import com.example.proyectoPrueba.model.DTO.ResultadoDTO;
import com.example.proyectoPrueba.model.entity.NivelContrasena;

/**
 * <b>Descripción:</b> Interface INivelContrasenaService que contiene lógica necesaria para realizar el llamado a su debido proceso de configurar contraseña
 * @author roger
 *
 */
public interface INivelContrasenaService {

	public ResultadoDTO guardarConfiguracionContrasena(String dato);
	
	public List<NivelContrasena> consultarConfiguracion();
}
