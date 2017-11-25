package ar.edu.unlam.tallerweb1.servicios.Curso;

import java.util.ArrayList;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.Curso.CursoDao;
import ar.edu.unlam.tallerweb1.modelo.Curso;


@Service("ServicioCurso")
@Transactional
public class ServicioCursoImpl implements ServicioCurso{

	@Inject
	private CursoDao cursoDao;
	
	@Transactional
	public void grabarCurso(Curso curso){
		cursoDao.grabarCurso(curso);
	}
	
	@Transactional
	public ArrayList<Curso> consultarTodosLosCursos(Long id){
		return cursoDao.consultarTodosLosCursos(id);
	}
	@Transactional
	public ArrayList<Curso> cursosParaAnotarse(){
		return cursoDao.cursosParaAnotarse();
	}
	
	/*@Transactional
	public ArrayList<Curso> cursosxId(long [] idCurso){
		return cursoDao.cursosxId(idCurso);
	}*/
	
	public Curso GetCurso(long idCurso){
		return cursoDao.GetCurso(idCurso);	
	}
}