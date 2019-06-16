package com.webapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.models.Estudiante;

@Repository
@Transactional
public interface EstudianteRepository extends CrudRepository<Estudiante, String>{
	
	Estudiante findByNombre(String nombre);
}
 