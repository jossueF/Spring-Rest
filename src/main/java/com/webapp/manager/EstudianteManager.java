package com.webapp.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.webapp.models.Estudiante;
import com.webapp.repository.EstudianteRepository;

@Component
public class EstudianteManager {

	@Autowired
	private EstudianteRepository repos;
	
	public Iterable<Estudiante> getEstudiantes(){
		Iterable<Estudiante> estudiantes = repos.findAll();
		return estudiantes;
	}
}
