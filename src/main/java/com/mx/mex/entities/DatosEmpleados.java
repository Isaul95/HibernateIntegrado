package com.mx.mex.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

	@Entity
	@Table (name= "DATOS_EMPLEADOS", schema="SYS_BAHENA")
	public class DatosEmpleados {
		@Id
		@Column(name= "ID_DATO_EMPLEADO", length = 11)
		private Long idDatosEmpleados;
		
		@Column(name = "NOMBRE_COMPLETO", length = 100)
		private String nombreCompleto;
		
		@Column(name = "RFC", length = 13)
		private String rfc;
		
		@Column(name = "EDAD", length = 3)
		private Long edad;
		
		@Column(name = "SEXO", length = 1)
		private String sexo;
		
		@Column(name = "DIRECCION", length = 100)
		private String direccion;
		
		@Column(name = "TELEFONO", length = 10)
		private Long telefono;
		
		@Column(name = "ACTIVO", length = 1)
		private Long activo;

		public String getNombreCompleto() {
			return nombreCompleto;
		}

		public void setNombreCompleto(String nombreCompleto) {
			this.nombreCompleto = nombreCompleto;
		}
		
		

		public Long getIdDatosEmpleados() {
			return idDatosEmpleados;
		}

		public void setIdDatosEmpleados(Long idDatosEmpleados) {
			this.idDatosEmpleados = idDatosEmpleados;
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

}
