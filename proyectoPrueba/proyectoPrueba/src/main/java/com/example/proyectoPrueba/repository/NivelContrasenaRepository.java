/**
 * 
 */
package com.example.proyectoPrueba.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.proyectoPrueba.model.entity.NivelContrasena;

/**
 * <b>Descripcion:</b> interface NivelContrasenaRepository que contiene la interacción con bd para sus respectivas validaciones
 * @author roger
 *
 */
@Repository
public interface NivelContrasenaRepository extends CrudRepository<NivelContrasena, Long>{

}
