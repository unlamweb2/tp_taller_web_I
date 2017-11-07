package ar.edu.unlam.tallerweb1.dao.Curso;

import java.util.ArrayList;

import ar.edu.unlam.tallerweb1.modelo.Curso;

// Interface que define los metodos del DAO de Usuarios.
public interface CursoDao {
	
	public void grabarCurso(Curso curso);
	public ArrayList<Curso> consultarTodosLosCursos(Long id);

}