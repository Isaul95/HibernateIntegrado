package com.mx.mex.Dto;

public class DatosEmpleadosDTO {
	
	private Long idDatosEmpleados;
	private String nombreCompleto;
	private String rfc;
	private Long edad;
	private String sexo;
	private String direccion;
	private Long telefono;
	private Long activo;
	
	private Integer code;/// 1= indicando que se hizo correctamente
	private String message;///indicando lo sucedido sea bueno o malo
	
	private Object content;//vamos a retomar informacion
	
	
	public Long getIdDatosEmpleados() {
		return idDatosEmpleados; 
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getContent() {
		return content;
	}
	public void setContent(Object content) {
		this.content = content;
	}
	public void setIdDatosEmpleados(Long idDatosEmpleados) {
		this.idDatosEmpleados = idDatosEmpleados;
	}
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public String getRfc() {
		return rfc;
	}
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	public Long getEdad() {
		return edad;
	}
	public void setEdad(Long edad) {
		this.edad = edad;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Long getTelefono() {
		return telefono;
	}
	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}
	public Long getActivo() {
		return activo;
	}
	public void setActivo(Long activo) {
		this.activo = activo;
	}
	public void setContent(String datosEmpleados) {
		// TODO Auto-generated method stub
		
	}
	

}
