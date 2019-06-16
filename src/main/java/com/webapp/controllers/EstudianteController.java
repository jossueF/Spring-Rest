package com.webapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.manager.EstudianteManager;
import com.webapp.models.Estudiante;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

	@Autowired
	private EstudianteManager manager;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Iterable<Estudiante>> getEstudiantes() {
		Iterable<Estudiante> estudiantes = manager.getEstudiantes();
		
		return new ResponseEntity<Iterable<Estudiante>>(estudiantes, HttpStatus.OK);
	}
}
