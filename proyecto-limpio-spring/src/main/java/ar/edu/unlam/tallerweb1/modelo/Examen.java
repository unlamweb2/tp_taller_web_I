package ar.edu.unlam.tallerweb1.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity
public class Examen {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	private String nombre;
	private String fecha;
	private String tipo;
	
	
	@OneToMany (fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn (name="idExamen")
	private List<Pregunta> preguntas;
	
	
	public Examen() {
		super();
	}


	public Examen(String nombre, String fecha, String tipo, List<Pregunta> preguntas) {
		super();
		this.nombre = nombre;
		this.fecha = fecha;
		this.tipo = tipo;
		this.preguntas = preguntas;
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


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public List<Pregunta> getPreguntas() {
		return preguntas;
	}


	public void setPreguntas(List<Pregunta> preguntas) {
		this.preguntas = preguntas;
	} 
	
	
		
	
				

}