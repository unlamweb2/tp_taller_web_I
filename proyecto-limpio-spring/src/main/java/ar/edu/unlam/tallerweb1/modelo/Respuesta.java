package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Respuesta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;	
	private String nombre;
	private Boolean correcta;
	
	@ManyToOne (fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn (name="idPregunta")
	private Pregunta pregunta;
	
	public Respuesta() {
		//super();
	}
	
	/*public Respuesta(String nombre, Boolean correcta) {
		super();
		this.nombre = nombre;
		this.correcta = correcta;
	}*/
		

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

	public Boolean getCorrecta() {
		return correcta;
	}

	public void setCorrecta(Boolean correcta) {
		this.correcta = correcta;
	}

	public Pregunta getPregunta() {
		return pregunta;
	}

	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}
	
	
	
	
}

