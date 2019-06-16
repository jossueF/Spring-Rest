package com.webapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.models.Estudiante;

@Repository
@Transactional
public interface EstudianteRepository extends CrudRepository<Estudiante, String>{

	//@Query(value="SELECT e FROM Estudiante e")
	//List<Estudiante> findAll();
	
}
 