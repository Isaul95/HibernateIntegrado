package entities.entityss;
// Generated 22/12/2022 04:15:31 PM by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * AlumnosNoviembre generated by hbm2java
 */
@Entity
@Table(name = "ALUMNOS_NOVIEMBRE", schema = "CURSOADMIN")
public class AlumnosNoviembre implements java.io.Serializable {

	private AlumnosNoviembreId id;

	public AlumnosNoviembre() {
	}

	public AlumnosNoviembre(AlumnosNoviembreId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "idAlumno", column = @Column(name = "ID_ALUMNO", precision = 10, scale = 0)),
			@AttributeOverride(name = "nombreDelAlumno", column = @Column(name = "NOMBRE_DEL_ALUMNO", length = 30)),
			@AttributeOverride(name = "edad", column = @Column(name = "EDAD", precision = 3, scale = 0)),
			@AttributeOverride(name = "fechaDeInscripcion", column = @Column(name = "FECHA_DE_INSCRIPCION", length = 7)),
			@AttributeOverride(name = "materia", column = @Column(name = "MATERIA", precision = 10, scale = 0)),
			@AttributeOverride(name = "maestro", column = @Column(name = "MAESTRO", precision = 10, scale = 0)) })
	public AlumnosNoviembreId getId() {
		return this.id;
	}

	public void setId(AlumnosNoviembreId id) {
		this.id = id;
	}

}
