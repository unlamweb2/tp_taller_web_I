package ar.edu.unlam.tallerweb1.dao;
import ar.edu.unlam.tallerweb1.modelo.Examen;
import ar.edu.unlam.tallerweb1.modelo.Pregunta;
import ar.edu.unlam.tallerweb1.modelo.Respuesta;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import javax.inject.Inject;

@Repository("ExamenDao")
public class ExamenDaoImpl implements ExamenDao {
	
	@Inject
    private SessionFactory sessionFactory;

	/*@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Examen> cargarExamen() {

		@SuppressWarnings("unused")
		ArrayList <Examen> examen = new ArrayList <Examen>();
		final Session session = sessionFactory.getCurrentSession();
		return (ArrayList<Examen>) session.createCriteria(Examen.class)
				.list();
	}*/
	
	@SuppressWarnings("unchecked")
	@Override
	public Examen cargarExamen(long idCurso){
		
		@SuppressWarnings("unused")	
		Examen ex;
		
		final Session session = sessionFactory.getCurrentSession();
		
		ex=  (Examen) session.createCriteria(Examen.class)
				.createAlias("curso", "miCurso")
				.add (Restrictions.eq("miCurso.id",idCurso))
    			.uniqueResult();				
		return ex;
		/*return (ArrayList<Curso>) session.createCriteria(Curso.class)
				.createAlias("usuarios", "miUsuario")
				.add(Restrictions.eq("miUsuario.id", id))
				.list();*/
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Respuesta> corregirRta(String[] rta){
		
		@SuppressWarnings("unused")	
		//ArrayList<Respuesta> correcta=new ArrayList <Respuesta>();;
		
		final Session session = sessionFactory.getCurrentSession();
		
		return (ArrayList<Respuesta>) session.createCriteria(Respuesta.class)
				.add (Restrictions.eq("nombre",rta))
    			.list();				
			
	}
	
	@SuppressWarnings("unchecked")
	@Override	
	 public ArrayList<Pregunta>  cargarPreguntaPorExamen(long Idexamen){
		
		@SuppressWarnings("unused")	
		ArrayList <Pregunta> pr;
		
		final Session session = sessionFactory.getCurrentSession();
		
		pr= (ArrayList<Pregunta>) session.createCriteria(Pregunta.class)
				.add (Restrictions.eq("examen.id",Idexamen))
    			.list();				
		
		return pr;	 
		 
	 }
}


