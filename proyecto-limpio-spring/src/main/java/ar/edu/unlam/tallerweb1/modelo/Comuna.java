package ar.edu.unlam.tallerweb1.modelo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Comuna {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String calle;
	private String numero;
	
	@OneToMany
	private Set<Barrio> barrio = new HashSet<Barrio>(0);
	
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
	public Comuna() {
	}
	
	public Set<Barrio> getBarrio() {
		return barrio;
	}
	public void setBarrio(Set<Barrio> barrio) {
		this.barrio = barrio;
	}

}