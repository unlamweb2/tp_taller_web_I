package ar.edu.unlam.tallerweb1.dao.Curso;
import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Curso;



@Repository("CursoDao")
public class CursoDaoImpl implements CursoDao{

	@Inject
 	private SessionFactory sessionFactory;	

	@Transactional
	public void grabarCurso(Curso curso){	
		Session s = sessionFactory.openSession();
		s.save(curso);		
	}
}