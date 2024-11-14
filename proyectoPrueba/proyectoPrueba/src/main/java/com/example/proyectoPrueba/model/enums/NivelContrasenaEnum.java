/**
 * 
 */
package com.example.proyectoPrueba.model.enums;

/**
 * <b>Descripcion:</b> Enumerado que contiene todos los niveles establecidos para cambios sobre la contraseña
 * @author roger
 *
 */
public enum NivelContrasenaEnum {
	
	   BAJO("^[0-9]"),
	   MEDIO("^[a-zA-Z]"),
	   ALTO("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%#$&/()=_*?&])([A-Za-z\\d$@$!%*?&]|[^ ])");
	   
	   /**
		 * Atributo que contiene la clave del mensaje para la internacionalizacion  
		 */
		private String codigoMensaje;

		/**
		 * Constructor que recibe como parametro el codigo del mensaje
		 * 
		 * @param codigoMensaje, Clave del mensaje para para internacionalizacion
		 */
		NivelContrasenaEnum(String codigoMensaje) {		
			this.codigoMensaje = codigoMensaje;
		}

		/**
		 * Metodo que retorna el valor del atributo
		 * 
		 * @return cadena con el codigo del mensaje
		 */
		public String getCodigoMensaje() {
			return codigoMensaje;
		}
		
		/***
		 * 
		 * Metodo encargado de retornar el enum segun su nombre 
		 * @param nombre
		 * @return
		 */
		public static NivelContrasenaEnum getEnumValue(String nombre) {
			if (nombre != null) {
				for (NivelContrasenaEnum nivelContrasena : NivelContrasenaEnum.values()) {
					if (nombre.equalsIgnoreCase(nivelContrasena.name())) {
						return nivelContrasena;
					}
				}
			}
			return null;
		}
}
