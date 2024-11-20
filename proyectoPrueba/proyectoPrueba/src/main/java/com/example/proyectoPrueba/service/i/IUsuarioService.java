/**
 * 
 */
package com.example.proyectoPrueba.service.i;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;

import com.example.proyectoPrueba.model.DTO.ResultadoDTO;
import com.example.proyectoPrueba.model.DTO.UsuarioDTO;
import com.example.proyectoPrueba.model.entity.Usuario;

/**
 * <b>Descripción:</b> Interface IUsuarioService que contiene lógica necesaria para realizar el llamado a su debido proceso de Usuario
 * @author roger
 *
 */
public interface IUsuarioService {
	
	/**
	 * <b>Descripción:</b> Método que contiene lógica necesaria para realizar el llamado a su debido proceso de registrar usuario
	 * @param usuario corresponde a los datos de usuario necesarios para el registro
	 */
	public ResultadoDTO registrarUsuario(UsuarioDTO usuario);
	
	/**
	 * <b>Descripción:</b> Método que contiene lógica necesaria para realizar el llamado a su debido proceso de modificar usuario
	 * @param usuario corresponde a los datos de usuario necesarios para la modificación
	 */
	public ResultadoDTO modificarUsuario(UsuarioDTO usuario);
	
	/**
	 * <b>Descripción:</b> Método que contiene lógica necesaria para realizar el llamado a su debido proceso de consultar a los usuarios 
	 */
	public List<Usuario> consultarUsuarios();
	
	/**
	 * <b>Descripción:</b> Método que contiene lógica necesaria para realizar el llamado a su debido proceso de eliminar usuario
	 * @param id dato de busqueda para la acción de eliminar
	 */
	public ResultadoDTO eliminarUsuario(UUID id);
	
	/**
	 * <b>Descripción:</b> Método que contiene lógica necesaria para realizar la busqueda de los usuario mediante filtro dinámico 
	 * @param usuario corresponde a los datos de usuario necesarios para la busqueda
	 */
	public List<Usuario> buscarUsuariosFiltroDinamico(UsuarioDTO usuarioDTO);

	/**
	 * <b>Descripción:</b> Método que contiene lógica necesaria para obtener los usuarios correspondientes a la pagina 
	 * @param pagina corresponde a la pagina de la vista
	 * @param tamanoPagina corresponde a la cantidad de datos a presentar en la vista 
	 */
	public Page<Usuario> obtenerUsuariosPaginados(int pagina, int tamanoPagina);
}
