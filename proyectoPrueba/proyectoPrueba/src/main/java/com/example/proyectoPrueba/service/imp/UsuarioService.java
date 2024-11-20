/**
 * 
 */
package com.example.proyectoPrueba.service.imp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.example.proyectoPrueba.repository.NivelContrasenaRepository;
import com.example.proyectoPrueba.repository.UsuarioRepository;
import com.example.proyectoPrueba.service.i.IUsuarioService;

import jakarta.persistence.criteria.Predicate;
import jakarta.transaction.Transactional;

import com.example.proyectoPrueba.model.DTO.ResultadoDTO;
import com.example.proyectoPrueba.model.DTO.TelefonoDTO;
import com.example.proyectoPrueba.model.DTO.UsuarioDTO;
import com.example.proyectoPrueba.model.entity.NivelContrasena;
import com.example.proyectoPrueba.model.entity.Telefono;
import com.example.proyectoPrueba.model.entity.Usuario;
import com.example.proyectoPrueba.model.enums.NivelContrasenaEnum;
import com.example.proyectoPrueba.security.PasswordUtil;


/**
 * <b>Descripción:</b> Clase UsuarioService que contiene toda la lógica necesaria para realizar su debido proceso de registro
 * @author roger
 *
 */
@Service
public class UsuarioService implements IUsuarioService{
	
	@Autowired
    private UsuarioRepository usuarioRepository;
	@Autowired
	private NivelContrasenaRepository nivelContrasenaRepository;
	
    private static final String DEFAULT_PASSWORD_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%#$&/()=_*?&])([A-Za-z\\d$@$!%*?&]|[^ ]){4,16}$";											
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
    private static final String CREATED ="HttpStatus.CREATED";
    private static final String BAD_REQUEST ="HttpStatus.BAD_REQUEST";
    private static final String OK ="HttpStatus.OK";
    
    /**
     * <b>Descripción:</b> Método encargado de registrar un usuario con sus validaciones
     * @author roger
     *
     */
    @Override
    public ResultadoDTO registrarUsuario(UsuarioDTO usuario) {
    	ResultadoDTO resultadoDTO = new ResultadoDTO();
    	resultadoDTO.setExitoso(true);
    	
    	if(controlUsuarioMensajesError(usuario,resultadoDTO).getMensaje()!=null) {
    		resultadoDTO.setExitoso(false);
    		resultadoDTO.setHttpStatus(BAD_REQUEST);
    		return resultadoDTO;
    	}
    	
		Usuario usuarioEntidad=convertirDtoEntidad(usuario);
		usuarioEntidad.setCreated(new Date());
		usuarioEntidad.setModified(new Date());
		usuarioEntidad.setPassword(PasswordUtil.encodePassword(usuario.getPassword()));
		usuarioRepository.save(usuarioEntidad);
		resultadoDTO.setHttpStatus(CREATED);
		resultadoDTO.setMensaje("{\"mensaje\": \"Usuario creado éxitosamente\"}");
		
		return resultadoDTO;
    }


	/**
     * <b>Descripción:</b> Método encargado de modificar un usuario con sus validaciones
     * @author roger
     *
     */
    @Override
	public ResultadoDTO  modificarUsuario(UsuarioDTO usuario) {
		ResultadoDTO resultadoDTO = new ResultadoDTO();
    	resultadoDTO.setExitoso(true);
		Optional<Usuario> usuarioId = usuarioRepository.findById(usuario.getId());
		if(usuarioId.isEmpty()) {
			resultadoDTO.setExitoso(false);
    		resultadoDTO.setHttpStatus(BAD_REQUEST);
    		resultadoDTO.setMensaje("{\"mensaje\": \"No se encontró usuario con ese id\"}");
    		return resultadoDTO;
		}
		
		if(controlUsuarioMensajesError(usuario,resultadoDTO).getMensaje()!=null) {
    		resultadoDTO.setExitoso(false);
    		resultadoDTO.setHttpStatus(BAD_REQUEST);
    		return resultadoDTO;
    	}
		
		Usuario usuarioEntidad=convertirDtoEntidad(usuario);
		usuarioEntidad.setId(usuario.getId());
		usuarioEntidad.setCreated(usuarioId.get().getCreated());
		usuarioEntidad.setModified(new Date());
		usuarioEntidad.setPassword(PasswordUtil.encodePassword(usuario.getPassword()));
		usuarioRepository.save(usuarioEntidad);
		resultadoDTO.setHttpStatus(OK);
		resultadoDTO.setMensaje("{\"mensaje\": \"El usuario ha sido modificado éxitosamente\"}");

		return resultadoDTO;
	}
	
	/**
	 * <b>Descripción:</b> Método que contiene lógica necesaria para realizar el debido proceso de consultar a los usuarios 
	 * @author roger
	 */
    @Override
	public List<Usuario> consultarUsuarios(){
		List<Usuario> usuario = (List<Usuario>) usuarioRepository.findAll();////////
		return usuario;
	}
	
	/**
	 * <b>Descripción:</b> Método que contiene lógica necesaria para realizar el debido proceso de eliminar usuario
	 * @param id dato de busqueda para la acción de eliminar
	 */
    @Override
	public ResultadoDTO eliminarUsuario(UUID id){
		ResultadoDTO resultadoDTO = new ResultadoDTO();
    	resultadoDTO.setExitoso(true);
		if(id == null) {
			resultadoDTO.setExitoso(false);
    		resultadoDTO.setHttpStatus(BAD_REQUEST);
    		resultadoDTO.setMensaje("{\"mensaje\": \"No se suministró el id\"}");
    		return resultadoDTO;
		}
		Optional<Usuario> usuarioId = usuarioRepository.findById(id);
		if(usuarioId.isEmpty()) {
			resultadoDTO.setExitoso(false);
    		resultadoDTO.setHttpStatus(BAD_REQUEST);
    		resultadoDTO.setMensaje("{\"mensaje\": \"No se encontró usuario con ese id\"}");
    		return resultadoDTO;
		}
		usuarioRepository.deleteById(id);
		resultadoDTO.setHttpStatus(OK);
		resultadoDTO.setMensaje("{\"mensaje\": \"El usuario ha sido eliminado éxitosamente\"}");
		return resultadoDTO;
	}


	/**
     * <b>Descripción:</b> Método encargado de convertir dto a entidad
     * @author roger
     *
     */
	private Usuario convertirDtoEntidad(UsuarioDTO usuario) {
		Usuario usuarioEntidad = new Usuario();
		List<Telefono> telefonos = new ArrayList<>();
		usuarioEntidad.setName(usuario.getName().trim());
		usuarioEntidad.setEmail(usuario.getEmail().trim());
		usuarioEntidad.setPassword(usuario.getPassword());
		usuarioEntidad.setLastLogin(new Date());
		usuarioEntidad.setToken(UUID.randomUUID().toString()); 
		usuarioEntidad.setActive(true);
	    if (usuario.getPhones() != null) {
	        for (TelefonoDTO telefonoDTO : usuario.getPhones()) {
	            Telefono telefono = new Telefono();
	            telefono.setNumber(telefonoDTO.getNumber().trim());
	            telefono.setCitycode(telefonoDTO.getCitycode().trim());
	            telefono.setCountrycode(telefonoDTO.getCountrycode().trim());
	            telefonos.add(telefono);
	        }
	    }
		usuarioEntidad.setPhones(telefonos);
		return usuarioEntidad;
	}

	
	/**
	 * <b>Descripción:</b> Método encargado de realizar la validación del correo
	 * @author roger
	 *
	 */
	private boolean validarCorreo(String correo) {
		if (correo == null || correo.isEmpty()) {
            return false;
        }
        Matcher matcher = EMAIL_PATTERN.matcher(correo);
        return matcher.matches();
	}
	
	/**
	 * <b>Descripción:</b> Método encargado de realizar la validación de la contraseña la cual de contar con una combinación de mínimo 4
	 * carácteres y entre ellos debe existir una letra miniscula, mayuscula,número y un carácter especial.
	 * @author roger
	 *
	 */
	private boolean validarPasword(String password) {
		if (password == null || password.isEmpty()) {
            return false;
        }
		String password_REGEX = null ;
		Pattern PASSWORD_PATTERN = null;
		PASSWORD_PATTERN = Pattern.compile(identificarNivelContrasena(password_REGEX));
		Matcher matcher = PASSWORD_PATTERN.matcher(password);
        return matcher.matches();
	}

	
	/**
	 * <b>Descripción:</b> Método encargado de identificar el nivel de la contraseña la cual debe contar con una combinación de mínimo 4
	 * carácteres, este método permite la posibilidad de modificar el nivel de seguridad de la contraseña, puede ser BAJO, MEDIO o ALTO
	 * @author roger
	 *
	 */
	private String identificarNivelContrasena(String password_REGEX) {
		List<NivelContrasena> nivelContrasena = (List<NivelContrasena>) nivelContrasenaRepository.findAll();///*/*/*/
		if(!nivelContrasena.isEmpty()) {
			if(nivelContrasena.get(0).getNivelContrasena().equals(NivelContrasenaEnum.BAJO.name())) {
				password_REGEX = NivelContrasenaEnum.BAJO.getCodigoMensaje() + "{" +
			            nivelContrasena.get(0).getCantidadMinima() + "," +
			            nivelContrasena.get(0).getCantidadMaxima() + "}$";
			}
			if(nivelContrasena.get(0).getNivelContrasena().equals(NivelContrasenaEnum.MEDIO.name())) {
				password_REGEX = NivelContrasenaEnum.MEDIO.getCodigoMensaje() + "{" +
			            nivelContrasena.get(0).getCantidadMinima() + "," +
			            nivelContrasena.get(0).getCantidadMaxima() + "}$";
			}
			if (nivelContrasena.get(0).getNivelContrasena().equals(NivelContrasenaEnum.ALTO.name())) {
				password_REGEX = NivelContrasenaEnum.ALTO.getCodigoMensaje() + "{" +
		            nivelContrasena.get(0).getCantidadMinima() + "," +
		            nivelContrasena.get(0).getCantidadMaxima() + "}$";
			}
		}else {
			password_REGEX = DEFAULT_PASSWORD_REGEX;					 
		}
		return password_REGEX;
	} 
	
	
	/**
     * <b>Descripción:</b> Método encargado de llevar el control de los mensajes de un usuario en sus validaciones de almacenamiento
     * @author roger
     *
     */
	private ResultadoDTO controlUsuarioMensajesError(UsuarioDTO usuario, ResultadoDTO resultadoDTO) {
		
		if(usuario.getName().isEmpty() || usuario.getEmail().isEmpty() || usuario.getPassword().isEmpty()) {
    		resultadoDTO.setMensaje("{\"mensaje\": \"No es posible registrar por falta de datos\"}");
		}
		if(!validarCorreo(usuario.getEmail())){
    		resultadoDTO.setMensaje("{\"mensaje\": \"El correo no cumple con el formato requerido\"}");
		}
		if(!validarPasword(usuario.getPassword())){
    		resultadoDTO.setMensaje("{\"mensaje\": \"La contraseña no cumple con el formato requerido\"}");
		}
		Optional<Usuario> usuarioCorreo = usuarioRepository.findByEmail(usuario.getEmail());
		
		if(usuarioCorreo.isPresent() && usuarioCorreo.get().getId() != usuario.getId()) {
    		resultadoDTO.setMensaje("{\"mensaje\": \"El correo ya se encuentra registrado\"}");
		}
		return resultadoDTO;
		
	}
	
	
	/**
     * <b>Descripción:</b> Método encargado de obtener las especificaciones dinámicas
     * @author roger
     */
    public Specification<Usuario> crearEspecificacion(UsuarioDTO usuarioDTO) {
        return Specification.where((root, query, criteriaBuilder) -> {
            Predicate predicate  = criteriaBuilder.conjunction();
        	
            if (usuarioDTO.getName() != null && !usuarioDTO.getName().isEmpty()) {
                //query.where(criteriaBuilder.like(root.get("name"), "%" + usuarioDTO.getName() + "%"));
            
            	predicate = criteriaBuilder.and(predicate,criteriaBuilder.like(root.get("name"), "%" + usuarioDTO.getName() + "%"));
            }
            if (usuarioDTO.getEmail() != null && !usuarioDTO.getEmail().isEmpty()) {
                predicate = criteriaBuilder.and(predicate,criteriaBuilder.like(root.get("email"), "%" + usuarioDTO.getEmail() + "%"));
            }
            //Retornar el predicado combinado, que contiene todas las condiciones unidas por el AND
            return predicate;
        });
    }
    
    
    /**
     * <b>Descripción:</b> Método encargado de la busqueda de usuario mediante filtro dinamico
     * @author roger
     */
    @Transactional
    @Override
    public List<Usuario> buscarUsuariosFiltroDinamico(UsuarioDTO usuarioDTO) {
        Specification<Usuario> especificacion = crearEspecificacion(usuarioDTO);
        return usuarioRepository.findAll(especificacion);
    }
    
    
    /**
     * <b>Descripción:</b> Método encargado de obtener usuarios paginados
     * @author roger
     */
    @Override
    public Page<Usuario> obtenerUsuariosPaginados(int pagina, int tamanoPagina){
    	Pageable pageable = PageRequest.of(pagina, tamanoPagina);
    	return usuarioRepository.findAll(pageable);    	
    }
}
