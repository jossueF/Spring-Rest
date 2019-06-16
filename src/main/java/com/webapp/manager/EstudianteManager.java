package com.webapp.manager;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;
import com.webapp.models.Estudiante;
import com.webapp.repository.EstudianteRepository;

@Component
public class EstudianteManager {

	@Autowired
	private EstudianteRepository repos;
	
	public List<Estudiante> getAllEstudiantes(){
		return Lists.newArrayList(repos.findAll());
	}
	
	public Optional<Estudiante> getEstudianteById(String id){
		Optional<Estudiante> estudiante = repos.findById(id);
		if(estudiante.isPresent()) {
			return estudiante;
		}
		else {
			return Optional.empty();
		}
	}
	
	public Optional<Estudiante> getEstudianteByName(String nombre) {
		Estudiante estudiante = repos.findByNombre(nombre);
		if(estudiante != null) {
			return Optional.of(estudiante);
		}
		else {
			return Optional.empty();
		}
	}
	
	public void deleteEstudiante(String id) {
		Optional<Estudiante> estudiante = repos.findById(id);
		if(estudiante.isPresent()) {
			repos.deleteById(id);
		}
	}
	
	public Estudiante createEstudiante(Estudiante estudiante) {
		return repos.save(estudiante);
	}
}

