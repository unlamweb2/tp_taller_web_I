package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Preguntas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String descripcion;
	private String rtaCorrecta;
	private String rtaIncorrecta1;
	private String rtaIncorrecta2;
	
	public Preguntas()
	{}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getRtaCorrecta() {
		return rtaCorrecta;
	}
	public void setRtaCorrecta(String rtaCorrecta) {
		this.rtaCorrecta = rtaCorrecta;
	}
	public String getRtaIncorrecta1() {
		return rtaIncorrecta1;
	}
	public void setRtaIncorrecta1(String rtaIncorrecta1) {
		this.rtaIncorrecta1 = rtaIncorrecta1;
	}
	public String getRtaIncorrecta2() {
		return rtaIncorrecta2;
	}
	public void setRtaIncorrecta2(String rtaIncorrecta2) {
		this.rtaIncorrecta2 = rtaIncorrecta2;
	}

}
