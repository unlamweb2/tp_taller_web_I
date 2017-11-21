package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Nota {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;	
	private long idUsuario;
	private long idExamen;
	private String Fecha;
	private float Calificacion;
				
	public Nota() {
		super();
		// TODO Auto-generated constructor stub
	}
	public float getCalificacion() {
		return Calificacion;
	}
	public void setCalificacion(float calificacion) {
		Calificacion = calificacion;
	}
	public Nota(long id, long idUsuario, long idExamen, String fecha) {
		super();
		this.id = id;
		this.idUsuario = idUsuario;
		this.idExamen = idExamen;
		Fecha = fecha;
	}
			
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public long getIdExamen() {
		return idExamen;
	}
	public void setIdExamen(long idExamen) {
		this.idExamen = idExamen;
	}
	public String getFecha() {
		return Fecha;
	}
	public void setFecha(String fecha) {
		Fecha = fecha;
	}
		

}
