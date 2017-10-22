package ar.edu.unlam.tallerweb1.dao.Docente;
import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ar.edu.unlam.tallerweb1.modelo.Docente;




@Repository("DocenteDao")
public class DocenteDAOImpl implements DocenteDao{

	@Inject
 	private SessionFactory sessionFactory;
	
	@Override
	public Docente consultarDocente (Docente docente) {

		final Session session = sessionFactory.getCurrentSession();
		return (Docente) session.createCriteria(Docente.class)
				.add(Restrictions.eq("email", docente.getEmail()))
				.add(Restrictions.eq("password", docente.getPassword()))
				
				.uniqueResult();
	}
	
	@Override
	public Docente consultarRol (Docente docente) {

		final Session session = sessionFactory.getCurrentSession();
		return (Docente) session.createCriteria(Docente.class)
				.add(Restrictions.eq("rol", "docente"))				
				.uniqueResult();
	}

	@Transactional
	public void grabarDocente(Docente docente){	
		Session s = sessionFactory.openSession();
		s.save(docente);		
	}
}