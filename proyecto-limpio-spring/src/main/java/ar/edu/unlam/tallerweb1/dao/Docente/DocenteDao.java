package ar.edu.unlam.tallerweb1.dao.Docente;
import ar.edu.unlam.tallerweb1.modelo.Docente;

// Interface que define los metodos del DAO de Usuarios.
public interface DocenteDao {
	
	Docente consultarDocente (Docente docente);
	public void grabarDocente (Docente docente);
	Docente consultarRol(Docente docente);

}