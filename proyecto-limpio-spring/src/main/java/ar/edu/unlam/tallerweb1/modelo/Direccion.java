package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Direccion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String calle;
	private String numero;
	private Barrio direccionBarrio;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public Direccion() {
	}

	@ManyToOne(cascade = CascadeType.ALL)
	public Barrio getDireccionBarrio() {
		return this.direccionBarrio;
	}

	public void setDireccionBarrio(Barrio direccionBarrio) {
		this.direccionBarrio = direccionBarrio;
	}
	
	public Direccion(String calle,String numero, Barrio direccionBarrio) {
		this.calle = calle;
		this.numero = numero;
		this.direccionBarrio = direccionBarrio;
	}
}
