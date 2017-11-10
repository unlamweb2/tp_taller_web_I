package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.ExamenDao;
import ar.edu.unlam.tallerweb1.modelo.Examen;
import ar.edu.unlam.tallerweb1.modelo.Pregunta;
import ar.edu.unlam.tallerweb1.modelo.Respuesta;

@Service("ServicioExamen")
@Transactional
public class ServicioExamenImpl implements ServicioExamen{

	@Inject
	private ExamenDao examendao;
	
	@Transactional
	public ArrayList<Examen> cargarExamen(){
		return examendao.cargarExamen();
	}
	
	@Transactional
	public Examen cargarExamen(long Idexamen){
		return examendao.cargarExamen(Idexamen);
	}

	@Transactional
	public ArrayList<Respuesta> corregirRta(String[] rta){
		return examendao.corregirRta(rta);
	}
	
	public ArrayList<Pregunta> cargarPreguntaPorExamen(long Idexamen){
		return examendao.cargarPreguntaPorExamen(Idexamen);		
	}
}


