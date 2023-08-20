package com.webapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.manager.EstudianteManager;
import com.webapp.models.Estudiante;
import io.swagger.annotations.ApiOperation;

// Comentario nuevo 20/08/2023
@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

	@Autowired
	private EstudianteManager manager;
	
	@ApiOperation(value="Obtener todos los estudiantes")
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Estudiante>> getEstudiantes() {	
		return new ResponseEntity<List<Estudiante>>(manager.getAllEstudiantes(), HttpStatus.OK);
	}
	
	@ApiOperation(value="Obtener un estudiante mediante el id")
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Estudiante> getEstudianteById(@PathVariable String id){
		return new ResponseEntity<Estudiante>(manager.getEstudianteById(id).get(), HttpStatus.OK);
	}
	
	@ApiOperation(value="Obtener un estudiante mediante el nombre")
	@RequestMapping(value="/name/{name}",method=RequestMethod.GET)
	public ResponseEntity<Estudiante> getEstudianteByName(@PathVariable String name){
		return new ResponseEntity<Estudiante>(manager.getEstudianteByName(name).get(), HttpStatus.OK);
	}
	
	@ApiOperation(value="Eliminar un estudiante de la base de datos")
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteEstudiante(@PathVariable String id){
		manager.deleteEstudiante(id);
		return ResponseEntity.notFound().build();
	}
}
