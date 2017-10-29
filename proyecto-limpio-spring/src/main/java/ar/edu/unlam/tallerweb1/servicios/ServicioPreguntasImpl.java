package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.PreguntasDao;


import ar.edu.unlam.tallerweb1.modelo.Preguntas;

@Service("ServicioPreguntas")
@Transactional
public class ServicioPreguntasImpl implements ServicioPreguntas{

	@Inject
	private PreguntasDao preguntasDao;
	
	@Transactional
	public ArrayList<Preguntas> cargarPreguntas(){
		return preguntasDao.cargarPreguntas();
	}
	
}
