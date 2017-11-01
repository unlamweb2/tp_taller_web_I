package ar.edu.unlam.tallerweb1.modelo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
public class Curso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idCurso;
	private String nombre;
	private long examenId;
	
	/*@ManyToMany(cascade = {CascadeType.ALL})
	@JoinColumn (name="idUsuario")
	private Set<Usuario> usuarios=new HashSet();*/
	
	//public Curso(){}
	
	
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
	public long getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(long idCurso) {
		this.idCurso = idCurso;
	}
	/*public Set<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}*/
	
	
	

	

}
