package entities.entityss;
// Generated 22/12/2022 04:15:31 PM by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * UsuariosAdminId generated by hbm2java
 */
@Embeddable
public class UsuariosAdminId implements java.io.Serializable {

	private long idUser;
	private String nombreCompleto;
	private String edad;
	private String direccion;
	private long estado;
	private long rol;

	public UsuariosAdminId() {
	}

	public UsuariosAdminId(long idUser, long estado, long rol) {
		this.idUser = idUser;
		this.estado = estado;
		this.rol = rol;
	}

	public UsuariosAdminId(long idUser, String nombreCompleto, String edad, String direccion, long estado, long rol) {
		this.idUser = idUser;
		this.nombreCompleto = nombreCompleto;
		this.edad = edad;
		this.direccion = direccion;
		this.estado = estado;
		this.rol = rol;
	}

	@Column(name = "ID_USER", nullable = false, precision = 11, scale = 0)
	public long getIdUser() {
		return this.idUser;
	}

	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}

	@Column(name = "NOMBRE_COMPLETO", length = 100)
	public String getNombreCompleto() {
		return this.nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	@Column(name = "EDAD", length = 50)
	public String getEdad() {
		return this.edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	@Column(name = "DIRECCION", length = 100)
	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Column(name = "ESTADO", nullable = false, precision = 11, scale = 0)
	public long getEstado() {
		return this.estado;
	}

	public void setEstado(long estado) {
		this.estado = estado;
	}

	@Column(name = "ROL", nullable = false, precision = 11, scale = 0)
	public long getRol() {
		return this.rol;
	}

	public void setRol(long rol) {
		this.rol = rol;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof UsuariosAdminId))
			return false;
		UsuariosAdminId castOther = (UsuariosAdminId) other;

		return (this.getIdUser() == castOther.getIdUser())
				&& ((this.getNombreCompleto() == castOther.getNombreCompleto())
						|| (this.getNombreCompleto() != null && castOther.getNombreCompleto() != null
								&& this.getNombreCompleto().equals(castOther.getNombreCompleto())))
				&& ((this.getEdad() == castOther.getEdad()) || (this.getEdad() != null && castOther.getEdad() != null
						&& this.getEdad().equals(castOther.getEdad())))
				&& ((this.getDireccion() == castOther.getDireccion()) || (this.getDireccion() != null
						&& castOther.getDireccion() != null && this.getDireccion().equals(castOther.getDireccion())))
				&& (this.getEstado() == castOther.getEstado()) && (this.getRol() == castOther.getRol());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getIdUser();
		result = 37 * result + (getNombreCompleto() == null ? 0 : this.getNombreCompleto().hashCode());
		result = 37 * result + (getEdad() == null ? 0 : this.getEdad().hashCode());
		result = 37 * result + (getDireccion() == null ? 0 : this.getDireccion().hashCode());
		result = 37 * result + (int) this.getEstado();
		result = 37 * result + (int) this.getRol();
		return result;
	}

}