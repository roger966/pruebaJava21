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
 * <b>Descripcion:</b> Entidad Telefono que contiene todos los atributos establecidos para un telefono
 * @author roger
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="TELEFONO")
public class Telefono {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String number;
    private String citycode;
    private String countrycode;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getCitycode() {
		return citycode;
	}
	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}
	/**
	 * @return the countrycode
	 */
	public String getCountrycode() {
		return countrycode;
	}
	/**
	 * @param countrycode the countrycode to set
	 */
	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}
}
