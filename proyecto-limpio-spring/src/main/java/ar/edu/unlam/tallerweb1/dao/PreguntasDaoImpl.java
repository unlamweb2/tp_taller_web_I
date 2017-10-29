package ar.edu.unlam.tallerweb1.dao;
import ar.edu.unlam.tallerweb1.modelo.Preguntas;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import javax.inject.Inject;

// implelemtacion del DAO de usuarios, la anotacion @Repository indica a Spring que esta clase es un componente que debe
// ser manejado por el framework, debe indicarse en applicationContext que busque en el paquete ar.edu.unlam.tallerweb1.dao
// para encontrar esta clase.
@Repository("preguntasDao")
public class PreguntasDaoImpl implements PreguntasDao {

	// Como todo dao maneja acciones de persistencia, normalmente estará inyectado el session factory de hibernate
	// el mismo está difinido en el archivo hibernateContext.xml
	@Inject
    private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Preguntas> cargarPreguntas() {

		@SuppressWarnings("unused")
		ArrayList <Preguntas> preguntas = new ArrayList <Preguntas>();
		final Session session = sessionFactory.getCurrentSession();
		return (ArrayList<Preguntas>) session.createCriteria(Preguntas.class)
				.list();
	}
	
}