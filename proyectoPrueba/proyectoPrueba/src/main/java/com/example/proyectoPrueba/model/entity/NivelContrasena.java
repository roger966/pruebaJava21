/**
 * 
 */
package com.example.proyectoPrueba.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <b>Descripcion:</b> Entidad Usuario que contiene todos los atributos establecidos para un usuario
 * @author roger
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="NivelContrasena")
public class NivelContrasena {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Long cantidadMinima;
    private Long cantidadMaxima;
    private String nivelContrasena;
    
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
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
