/**
 * 
 */
package com.example.proyectoPrueba.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;


/**
 * @author roger
 *
 */
@Data
@AllArgsConstructor

public class ResultadoDTO {
	
	private boolean exitoso;
    private String mensaje;
    private String httpStatus;
	
    public ResultadoDTO() {
	
	}

	/**
	 * @return the exitoso
	 */
	public boolean isExitoso() {
		return exitoso;
	}

	/**
	 * @param exitoso the exitoso to set
	 */
	public void setExitoso(boolean exitoso) {
		this.exitoso = exitoso;
	}

	/**
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * @param mensaje the mensaje to set
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	/**
	 * @return the httpStatus
	 */
	public String getHttpStatus() {
		return httpStatus;
	}

	/**
	 * @param httpStatus the httpStatus to set
	 */
	public void setHttpStatus(String httpStatus) {
		this.httpStatus = httpStatus;
	}
}
