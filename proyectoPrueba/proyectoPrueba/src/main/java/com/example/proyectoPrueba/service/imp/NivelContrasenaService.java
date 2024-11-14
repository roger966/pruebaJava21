/**
 * 
 */
package com.example.proyectoPrueba.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.proyectoPrueba.model.DTO.ResultadoDTO;
import com.example.proyectoPrueba.model.entity.NivelContrasena;
import com.example.proyectoPrueba.model.enums.NivelContrasenaEnum;
import com.example.proyectoPrueba.repository.NivelContrasenaRepository;
import com.example.proyectoPrueba.service.i.INivelContrasenaService;

/**
 * <b>Descripción:</b> Clase NivelContrasenaService que contiene toda la lógica necesaria para realizar su debido proceso de nivel de contraseña
 * @author roger
 *
 */
@Service
public class NivelContrasenaService implements INivelContrasenaService{
	
	private static final String BAD_REQUEST ="HttpStatus.BAD_REQUEST";
    private static final String OK ="HttpStatus.OK";
    
	@Autowired
    private NivelContrasenaRepository nivelContrasenaRepository;
	
	 /**
     * <b>Descripción:</b> Método encargado de guardar una configuración de contraseña con sus validaciones
     * @author roger
     *
     */
	public ResultadoDTO guardarConfiguracionContrasena(String dato) {
		ResultadoDTO resultadoDTO = new ResultadoDTO();
		resultadoDTO.setExitoso(true);
		Long minimo,maximo;
		if(dato == null) {
			resultadoDTO.setExitoso(false);
    		resultadoDTO.setHttpStatus(BAD_REQUEST);
    		resultadoDTO.setMensaje("{\"mensaje\": \"No es posible configurar la contraseña, no se recibieron datos\"}");
    		return resultadoDTO;
		}
		nivelContrasenaRepository.deleteAll();
		String[] datos=dato.split(",");
		minimo=Long.parseLong(datos[0]);
		maximo=Long.parseLong(datos[1]);
		if(minimo>=maximo) {
			resultadoDTO.setExitoso(false);
    		resultadoDTO.setHttpStatus(BAD_REQUEST);
    		resultadoDTO.setMensaje("{\"mensaje\": \"La cantidad mínima no puede ser mayor o igual que la cantidad máxima\"}");
    		return resultadoDTO;
		}
		if(minimo<4||maximo>16) {
			resultadoDTO.setExitoso(false);
    		resultadoDTO.setHttpStatus(BAD_REQUEST);
    		resultadoDTO.setMensaje("{\"mensaje\": \"El rango de las cantidades mínima y máxima no son congruentes\"}");
    		return resultadoDTO;
			
		}
		if(!(datos[2].equals(String.valueOf(NivelContrasenaEnum.BAJO))||
			datos[2].equals(String.valueOf(NivelContrasenaEnum.MEDIO))||
			datos[2].equals(String.valueOf(NivelContrasenaEnum.ALTO)))) {
			resultadoDTO.setExitoso(false);
    		resultadoDTO.setHttpStatus(BAD_REQUEST);
    		resultadoDTO.setMensaje("{\"mensaje\": \"Nivel de contraseña errado\"}");
    		return resultadoDTO;
		}
		NivelContrasena nivelContrasena = new NivelContrasena();
		nivelContrasena.setCantidadMinima(Long.parseLong(datos[0]));
		nivelContrasena.setCantidadMaxima(Long.parseLong(datos[1]));
		nivelContrasena.setNivelContrasena(String.valueOf(datos[2]));
		nivelContrasenaRepository.save(nivelContrasena);
		resultadoDTO.setHttpStatus(OK);
		resultadoDTO.setMensaje("{\"mensaje\": \"Configuracion de contraseña registrada éxitosamente\"}");
		return resultadoDTO;
	}

	 /**
     * <b>Descripción:</b> Método encargado de consultar el nivel de contraseña parametrizado
     * @author roger
     *
     */
	@Override
	public List<NivelContrasena> consultarConfiguracion() {
		List<NivelContrasena> nivelContrasena;
		nivelContrasena=(List<NivelContrasena>) nivelContrasenaRepository.findAll();//*/*/*/*///////
		return nivelContrasena;
	}
}
