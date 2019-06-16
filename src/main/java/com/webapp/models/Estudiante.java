package com.webapp.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name="estudiantes")
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class Estudiante{

	@Column(name="nombre", nullable=false)
	private String nombre;
	
	@Column(name="apellido_paterno", nullable=false)
	private String apellidoPaterno;
	
	@Column(name="apellido_materno", nullable=false)
	private String apellidoMaterno;

	@Column(name="email", nullable=true)
	private String email;
	
	@Column(name="calle", nullable=false)
	private String calle;
	
	@Column(name="ciudad", nullable=false)
	private String ciudad;
	
	@Column(name="estado", nullable=false)
	private String estado;
	
	@Column(name="cp", nullable=false)
	private Integer cp;
	
	@Column(name="telefono", nullable=false)
	private String telefono;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name="fecha_nacimiento", nullable=false)
	private Date fechaNacimiento;
	
	@Column(name="sexo", nullable=false)
	private String sexo;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name="fecha_ingreso", nullable=false)
	private Date fechaIngreso;
	
	@Id
	@Column(name="estudiante_id", unique=true, nullable=false)
	private String estudianteID;
	
	public Estudiante(String nombre, String apellidoPaterno, String apellidoMaterno, String email, String calle,
			String ciudad, String estado, Integer cp, String telefono, Date fechaNacimiento, String sexo,
			Date fechaIngreso, String estudianteID) {
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.email = email;
		this.calle = calle;
		this.ciudad = ciudad;
		this.estado = estado;
		this.cp = cp;
		this.telefono = telefono;
		this.fechaNacimiento = fechaNacimiento;
		this.sexo = sexo;
		this.fechaIngreso = fechaIngreso;
		this.estudianteID = estudianteID;
	}

	@PrePersist
	private void preInitial() {
		this.fechaNacimiento = new Date();
		this.fechaIngreso = new Date();
	}

	
	
}
