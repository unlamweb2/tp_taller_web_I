package ar.edu.unlam.tallerweb1.dao.Respuestas;


import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Respuesta;



@Repository("RespuestaDao")
public class RespuestaDaoImpl implements RespuestaDao{

	@Inject
 	private SessionFactory sessionFactory;	

	@Transactional
	public void grabarRespuesta(Respuesta Respuesta){	
		Session s = sessionFactory.openSession();
		s.save(Respuesta);		
		
	}

}