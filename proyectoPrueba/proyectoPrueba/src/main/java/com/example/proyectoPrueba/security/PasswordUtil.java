/**
 * 
 */
package com.example.proyectoPrueba.security;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * <b>Descripcion:</b> Clase PasswordUtil que contiene logica de seguridad en datos sensibles para garantizar el registro de un usuario
 * @author roger
 *
 */
public class PasswordUtil {
	
	private static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	/**
	 * Método que genera la códificación de la contraseña que se pretende almacenar
	 * @param String
	 * @return String
	 */
    public static String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }
    
    /**
     * Método qe genera la verificación del password almacenado al usuario registrado en BD
     * @param rawPassword
     * @param encodedPassword
     * @return boolean
     */
    public static boolean verifyPassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}
