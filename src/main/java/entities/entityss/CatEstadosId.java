package entities.entityss;
// Generated 22/12/2022 04:15:31 PM by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * CatEstadosId generated by hbm2java
 */
@Embeddable
public class CatEstadosId implements java.io.Serializable {

	private long idEstado;
	private String nombre;
	private String abreviatura;

	public CatEstadosId() {
	}

	public CatEstadosId(long idEstado) {
		this.idEstado = idEstado;
	}

	public CatEstadosId(long idEstado, String nombre, String abreviatura) {
		this.idEstado = idEstado;
		this.nombre = nombre;
		this.abreviatura = abreviatura;
	}

	@Column(name = "ID_ESTADO", nullable = false, precision = 11, scale = 0)
	public long getIdEstado() {
		return this.idEstado;
	}

	public void setIdEstado(long idEstado) {
		this.idEstado = idEstado;
	}

	@Column(name = "NOMBRE", length = 100)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "ABREVIATURA", length = 50)
	public String getAbreviatura() {
		return this.abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CatEstadosId))
			return false;
		CatEstadosId castOther = (CatEstadosId) other;

		return (this.getIdEstado() == castOther.getIdEstado())
				&& ((this.getNombre() == castOther.getNombre()) || (this.getNombre() != null
						&& castOther.getNombre() != null && this.getNombre().equals(castOther.getNombre())))
				&& ((this.getAbreviatura() == castOther.getAbreviatura())
						|| (this.getAbreviatura() != null && castOther.getAbreviatura() != null
								&& this.getAbreviatura().equals(castOther.getAbreviatura())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getIdEstado();
		result = 37 * result + (getNombre() == null ? 0 : this.getNombre().hashCode());
		result = 37 * result + (getAbreviatura() == null ? 0 : this.getAbreviatura().hashCode());
		return result;
	}

}