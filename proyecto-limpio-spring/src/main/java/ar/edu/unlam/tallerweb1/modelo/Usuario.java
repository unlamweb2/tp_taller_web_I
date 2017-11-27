package ar.edu.unlam.tallerweb1.modelo;

import java.io.Serializable;
import java.util.ArrayList;
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

// Clase que modela el concepto de Usuario, la anotacion @Entity le avisa a hibernate que esta clase es persistible
// el paquete ar.edu.unlam.tallerweb1.modelo esta indicado en el archivo hibernateCOntext.xml para que hibernate
// busque entities en él
@Entity 
@Table(name="Usuario")

public class Usuario implements Serializable{

	// La anotacion id indica que este atributo es el utilizado como clave primaria de la entity, se indica que el valor es autogenerado.
	@Id
	@Column(name="Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	// para el resto de los atributo no se usan anotaciones entonces se usa el default de hibernate: la columna se llama igual que
	// el atributo, la misma admite nulos, y el tipo de dato se deduce del tipo de dato de java.
	private String email;
	private String nombre;
	private String apellido;
	private String password;
	private String rol;
	
	/*@ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="UsuarioCurso")
    private Set<Curso> cursos=new HashSet<Curso>();*/
	 /*@ManyToMany
	    Set<Curso> cursos;*/
	 
	/* @ManyToMany(cascade = {CascadeType.ALL})POSTA
		private List<Curso> cursos;*/
	 
	 @ManyToOne (fetch=FetchType.EAGER, cascade=CascadeType.ALL)
		@JoinColumn (name="idCurso")
		private Curso curso;
	
	public Usuario(){};
	public Usuario(String email,String password, String rol) {
		this.email = email;
		this.password = password;
		this.rol= rol;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Curso getCursos() {
		return curso;
	}
	public void setCursos (Curso curso) {
		this.curso = curso;
	}
	
}
