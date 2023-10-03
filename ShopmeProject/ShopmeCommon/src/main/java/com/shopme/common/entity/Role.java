package com.shopme.common.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 50, nullable = false, unique = true) /// con esto evitamos que dos roles tengan el mismo nombre
	private String nombre;
	
	@Column(length = 200, nullable = false) 
	private String descripcion;
	
	/// creamos el constructor vacio

	public Role() {
		
	}
	
	
	
	public Role(Integer id) {
		
		this.id = id;
	}



	/// creamos un costructor con solo el campo de nombre
	public Role(String nombre) {
		
		this.nombre = nombre;
	}
	/// creamos un cosntructor con nombre y descripcion 
	public Role(String nombre, String descripcion) {
	
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	@Override
	public int hashCode() {
		return Objects.hash(id);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		return Objects.equals(id, other.id);
	}



	@Override
	public String toString() {
		return this.nombre;
	}

	

}
