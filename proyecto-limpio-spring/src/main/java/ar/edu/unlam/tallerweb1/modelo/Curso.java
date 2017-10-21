package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Curso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nombre;
	private long docenteId;
	private long alumnoID;
	private long examenId;
	
	
	//public Curso(){}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public long getExamenId() {
		return examenId;
	}
	public void setExamenId(long examenId) {
		this.examenId = examenId;
	}
	public long getDocenteId() {
		return docenteId;
	}
	public void setDocenteId(long docenteId) {
		this.docenteId = docenteId;
	}
	public long getAlumnoID() {
		return alumnoID;
	}
	public void setAlumnoID(long alumnoID) {
		this.alumnoID = alumnoID;
	}

	

}
