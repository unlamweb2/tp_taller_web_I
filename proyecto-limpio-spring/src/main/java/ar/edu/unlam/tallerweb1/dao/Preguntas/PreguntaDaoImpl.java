package ar.edu.unlam.tallerweb1.dao.Preguntas;


import java.sql.SQLIntegrityConstraintViolationException;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import ar.edu.unlam.tallerweb1.modelo.Pregunta;



@Repository("PreguntaDao")
public class PreguntaDaoImpl implements PreguntaDao{

	@Inject
 	private SessionFactory sessionFactory;	

	@Transactional
	public void grabarPregunta(Pregunta Pregunta){	
		Session s = sessionFactory.openSession();
		s.save(Pregunta);		
		
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public Pregunta cargarPregunta(long IdPregunta){
		
		@SuppressWarnings("unused")	
		Pregunta pr;
		
		final Session session = sessionFactory.getCurrentSession();
		
		pr=  (Pregunta) session.createCriteria(Pregunta.class)
				.add (Restrictions.eq("id",IdPregunta))
    			.uniqueResult();				
		return pr;
		}
	
	
	@Override
	public boolean borrarPregunta(Pregunta pregunta){
		boolean Borro=false;
		final Session session = sessionFactory.getCurrentSession();
				
		try
		{	session.update(pregunta);
			session.delete(pregunta);
			Borro=true;
		}
		catch(org.hibernate.exception.ConstraintViolationException ex){
			Borro=false;
		}
				
		return Borro;
	
	}

	
}