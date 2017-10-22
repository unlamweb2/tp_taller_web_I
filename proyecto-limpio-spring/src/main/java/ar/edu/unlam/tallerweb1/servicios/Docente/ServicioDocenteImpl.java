package ar.edu.unlam.tallerweb1.servicios.Docente;

import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ar.edu.unlam.tallerweb1.dao.Docente.DocenteDao;
import ar.edu.unlam.tallerweb1.modelo.Docente;

@Service("ServicioDocente")
@Transactional
public class ServicioDocenteImpl implements ServicioDocente{

	@Inject
	private DocenteDao docenteDao;
	
	@Transactional
	public void grabarDocente(Docente docente){
		docenteDao.grabarDocente(docente);
	}
	
	@Override
	public Docente consultarDocente(Docente docente) {
		return docenteDao.consultarDocente(docente);
	}
	
	@Override
	public Docente consultarRol(Docente docente) {
		return docenteDao.consultarRol(docente);
	}
	
}

