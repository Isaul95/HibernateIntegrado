package entities.entityss;
// Generated 22/12/2022 04:15:31 PM by Hibernate Tools 4.3.5.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Curso generated by hbm2java
 */
@Entity
@Table(name = "CURSO", schema = "CURSOADMIN")
public class Curso implements java.io.Serializable {

	private long idCurso;
	private String nombreMateria;
	private String descripcion;
	private Date fechaCreacion;
	private Set<Alumnos> alumnoses = new HashSet<Alumnos>(0);

	public Curso() {
	}

	public Curso(long idCurso) {
		this.idCurso = idCurso;
	}

	public Curso(long idCurso, String nombreMateria, String descripcion, Date fechaCreacion, Set<Alumnos> alumnoses) {
		this.idCurso = idCurso;
		this.nombreMateria = nombreMateria;
		this.descripcion = descripcion;
		this.fechaCreacion = fechaCreacion;
		this.alumnoses = alumnoses;
	}

	@Id

	@Column(name = "ID_CURSO", unique = true, nullable = false, precision = 10, scale = 0)
	public long getIdCurso() {
		return this.idCurso;
	}

	public void setIdCurso(long idCurso) {
		this.idCurso = idCurso;
	}

	@Column(name = "NOMBRE_MATERIA", length = 30)
	public String getNombreMateria() {
		return this.nombreMateria;
	}

	public void setNombreMateria(String nombreMateria) {
		this.nombreMateria = nombreMateria;
	}

	@Column(name = "DESCRIPCION", length = 30)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_CREACION", length = 7)
	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "curso")
	public Set<Alumnos> getAlumnoses() {
		return this.alumnoses;
	}

	public void setAlumnoses(Set<Alumnos> alumnoses) {
		this.alumnoses = alumnoses;
	}

}
