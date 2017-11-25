package ar.edu.unlam.tallerweb1.servicios.Curso;

import java.util.ArrayList;

import ar.edu.unlam.tallerweb1.modelo.Curso;

public interface ServicioCurso {

	public void grabarCurso(Curso curso);
	public ArrayList<Curso> consultarTodosLosCursos(Long id);
	public ArrayList<Curso> cursosParaAnotarse();
	//public ArrayList<Curso> cursosxId(long[] idCurso);
	public Curso GetCurso(long idCurso);
}
