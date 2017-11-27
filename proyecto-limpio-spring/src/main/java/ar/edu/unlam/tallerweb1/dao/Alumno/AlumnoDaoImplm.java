package ar.edu.unlam.tallerweb1.dao.Alumno;

import java.util.ArrayList;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.Curso.CursoDao;
import ar.edu.unlam.tallerweb1.modelo.Curso;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Repository("AlumnoDao")
public class AlumnoDaoImplm implements AlumnoDao{
	
	@Inject
 	private SessionFactory sessionFactory;	
	
	@Transactional
	public void anotarAlumno(Usuario alumno){

		Session s = sessionFactory.openSession();
		s.update(alumno);
	}

}

