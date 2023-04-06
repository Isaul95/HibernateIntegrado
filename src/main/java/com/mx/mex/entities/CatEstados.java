package com.mx.mex.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CAT_ESTADOS", schema = "SYS_BAHENA")
public class CatEstados {
	
	private Long idEstado;
	private String nombre;
	private String abreviatura;
	
	@Id
	@Column(name = "ID_ESTADO", unique = true, nullable = false, precision = 11, scale = 0)
	public Long getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(Long idEstado) {
		this.idEstado = idEstado;
	}
	
	@Column(name = "NOMBRE", length = 100)
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Column(name = "ABREVIATURA", length = 50)
	public String getAbreviatura() {
		return abreviatura;
	}
	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}
	

} // Fin class
