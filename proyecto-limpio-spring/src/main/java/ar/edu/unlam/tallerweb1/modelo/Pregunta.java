package ar.edu.unlam.tallerweb1.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Pregunta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	private String nombre;
	
	@OneToMany (fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn (name="idPregunta")
	private List<Respuesta> respuestas; 
	
	
	@ManyToOne (fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn (name="idExamen")
	private Examen examen;

	public Pregunta() {
		super();
	}

	public Pregunta(String nombre, List<Respuesta> respuestas) {
		super();
		this.nombre = nombre;
		this.respuestas = respuestas;	
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public List<Respuesta> getRespuestas() {
		return respuestas;
	}


	public void setRespuestas(List<Respuesta> Respuestas) {
		respuestas = Respuestas;
	}


	public Examen getExamen() {
		return examen;
	}


	public void setExamen(Examen examen) {
		this.examen = examen;
	}
	
	

}
