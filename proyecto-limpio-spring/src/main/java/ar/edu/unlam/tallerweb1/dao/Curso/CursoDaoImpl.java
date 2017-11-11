package ar.edu.unlam.tallerweb1.dao.Curso;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Curso;
import ar.edu.unlam.tallerweb1.modelo.Usuario;



@Repository("CursoDao")
public class CursoDaoImpl implements CursoDao{

	@Inject
 	private SessionFactory sessionFactory;	

	@Transactional
	public void grabarCurso(Curso curso){	
		Session s = sessionFactory.openSession();
		s.save(curso);		
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Curso> consultarTodosLosCursos(Long id)
	{		
		final Session session = sessionFactory.getCurrentSession();
		
		
		return (ArrayList<Curso>) session.createCriteria(Curso.class)
				.createAlias("usuarios", "miUsuario")//usuarios viene de 
				.add(Restrictions.eq("miUsuario.id", id))
				.list();
}
	
	
}