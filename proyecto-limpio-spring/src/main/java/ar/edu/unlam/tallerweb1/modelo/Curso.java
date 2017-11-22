package ar.edu.unlam.tallerweb1.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@SuppressWarnings("serial")
@Entity
@Table(name="Curso")
public class Curso implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nombre;
			
	/* @ManyToMany(cascade = {CascadeType.ALL},mappedBy="cursos")
	 Set<Usuario> usuarios;*/
	 
	 @ManyToMany(cascade = {CascadeType.ALL},mappedBy="cursos")			
	private List<Usuario> usuarios;
	 
	/*@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn (name="idCurso")	
	@Fetch(value = FetchMode.SUBSELECT)	
	private List<Examen> examen;*/
	
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn (name="idCurso")	
	@Fetch(value = FetchMode.SUBSELECT)	
	private List<Examen> examen;
	 
	public Curso(){}
	
	public List<Examen> getExamen() {
		return examen;
	}

	public void setExamen(List<Examen> examen) {
		this.examen = examen;
	}

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
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	
}
