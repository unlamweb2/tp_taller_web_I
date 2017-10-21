package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Docente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nombre;
	private String apellido;
	private String email;
	private String rol;
	private long cursoID;
	private long examenId;
	private String password;
	
	public Docente(){}
	
	/*public Docente(String nombre,String apellido) {
		this.nombre = nombre;
		this.apellido = apellido;	
		this.rol = "docente";
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
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public long getCursoID() {
		return cursoID;
	}
	public void setCursoID(long cursoID) {
		this.cursoID = cursoID;
	}
	public long getExamenId() {
		return examenId;
	}
	public void setExamenId(long examenId) {
		this.examenId = examenId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
}
