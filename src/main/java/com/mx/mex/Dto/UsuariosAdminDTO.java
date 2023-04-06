package com.mx.mex.Dto;

import java.math.BigDecimal;

public class UsuariosAdminDTO {
	
	private Long idUser;
	private String nombreCompleto;
	private String edad;	
	private String direccion;
	private String estado;
	private String rol;
	
	private int estadoInt;
	private int rolInt;
	
	
	
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	
	public String getEdad() {
		return edad;
	}
	public void setEdad(String edad) {
		this.edad = edad;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public int getEstadoInt() {
		return estadoInt;
	}
	public void setEstadoInt(int estadoInt) {
		this.estadoInt = estadoInt;
	}
	public int getRolInt() {
		return rolInt;
	}
	public void setRolInt(int rolInt) {
		this.rolInt = rolInt;
	}
	

} // Fin de la class
