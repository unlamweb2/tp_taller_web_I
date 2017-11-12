package ar.edu.unlam.tallerweb1.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@SuppressWarnings("serial")
@Entity
@Table(name="Curso")
public class Curso implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nombre;
	
	
	 @ManyToMany(cascade = {CascadeType.ALL},mappedBy="cursos")
	 Set<Usuario> usuarios;
	 
	 @OneToMany
	 private Set<Examen> examen = new HashSet<Examen>(0);
	 
	public Curso(){}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long idCurso) {
		this.id = idCurso;
	}
	
	public Set<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	public Set<Examen> getExamen() {
		return examen;
	}

	public void setExamen(Set<Examen> examen) {
		this.examen = examen;
	}
}
