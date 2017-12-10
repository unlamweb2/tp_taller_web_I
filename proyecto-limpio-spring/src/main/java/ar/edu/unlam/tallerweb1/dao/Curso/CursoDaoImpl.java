package ar.edu.unlam.tallerweb1.dao.Curso;
import java.util.ArrayList;
import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
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
	
	@Transactional
	public void agregar(Curso curso){	
		//Session s = sessionFactory.openSession();
		final Session session = sessionFactory.getCurrentSession();
		session.update(curso);		
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Curso> consultarTodosLosCursos(Long id)
	{		
		final Session session = sessionFactory.getCurrentSession();
		
		
		return (ArrayList<Curso>) session.createCriteria(Curso.class)
				.createAlias("usuarios", "miUsuario")
				.add(Restrictions.eq("miUsuario.id", id))
				.list();
}
	public Curso consultarCursoAlumno(long id)
	{		
		final Session session = sessionFactory.getCurrentSession();
		
		
		return (Curso) session.createCriteria(Curso.class)
				.createAlias("usuarios", "miUsuario")
				.add(Restrictions.eq("miUsuario.id", id))
				.uniqueResult();
}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Curso> cursosParaAnotarse()
	{		
		final Session session = sessionFactory.getCurrentSession();
		//Me trae cada curso con examen repetido x3
		/*return (ArrayList<Curso>) session.createCriteria(Curso.class)
				.createAlias("examen", "Examenes")
				.add(Restrictions.NotNull("Examenes.id")
				.list();*/
		return (ArrayList<Curso>) session.createCriteria(Curso.class)
				.list();
}
	@SuppressWarnings("unchecked")
	public ArrayList<Curso> cursosxId(long[] idCurso)
	{		
		final Session session = sessionFactory.getCurrentSession();
		
		return (ArrayList<Curso>) session.createCriteria(Curso.class)
				.add(Restrictions.eq("id",idCurso))
				.list();
	}
	
	public Curso GetCurso(long idCurso){
			final Session session = sessionFactory.getCurrentSession();
		
		return (Curso) session.createCriteria(Curso.class)
				.add(Restrictions.eq("id",idCurso))
				.uniqueResult();			
	}
	
	
}