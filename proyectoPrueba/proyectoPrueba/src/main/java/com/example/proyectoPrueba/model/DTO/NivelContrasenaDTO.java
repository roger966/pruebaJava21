/**
 * 
 */
package com.example.proyectoPrueba.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author roger
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NivelContrasenaDTO {
	
	private Long cantidadMinima;
	private Long cantidadMaxima;
	private String nivelContrasena;
	
	/**
	 * @return the cantidadMinima
	 */
	public Long getCantidadMinima() {
		return cantidadMinima;
	}
	/**
	 * @param cantidadMinima the cantidadMinima to set
	 */
	public void setCantidadMinima(Long cantidadMinima) {
		this.cantidadMinima = cantidadMinima;
	}
	/**
	 * @return the cantidadMaxima
	 */
	public Long getCantidadMaxima() {
		return cantidadMaxima;
	}
	/**
	 * @param cantidadMaxima the cantidadMaxima to set
	 */
	public void setCantidadMaxima(Long cantidadMaxima) {
		this.cantidadMaxima = cantidadMaxima;
	}
	/**
	 * @return the nivelContrasena
	 */
	public String getNivelContrasena() {
		return nivelContrasena;
	}
	/**
	 * @param nivelContrasena the nivelContrasena to set
	 */
	public void setNivelContrasena(String nivelContrasena) {
		this.nivelContrasena = nivelContrasena;
	}
}
