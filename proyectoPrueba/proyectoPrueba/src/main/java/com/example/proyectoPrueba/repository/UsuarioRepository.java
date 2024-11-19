/**
 * 
 */
package com.example.proyectoPrueba.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.proyectoPrueba.model.entity.Usuario;

/**
 * <b>Descripcion:</b> interface UsuarioRepository que contiene la interacción con bd para sus respectivas validaciones
 * @author roger
 *
 */
@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, UUID>, JpaSpecificationExecutor<Usuario>{
	
	Optional<Usuario> findByEmail(String email);
}
