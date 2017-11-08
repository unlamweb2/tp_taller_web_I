package ar.edu.unlam.tallerweb1.servicios.Preguntas;

import java.util.ArrayList;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.Preguntas.PreguntaDao;
import ar.edu.unlam.tallerweb1.modelo.Pregunta;


@Service("ServicioPregunta")
@Transactional
public class ServicioPreguntaImpl implements ServicioPregunta{

	@Inject
	private PreguntaDao PreguntaDao;
	
	@Transactional
	public void grabarPregunta(Pregunta Pregunta){
		PreguntaDao.grabarPregunta(Pregunta);
		
	}
	
			
}