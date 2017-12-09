package ar.edu.unlam.tallerweb1.servicios.Preguntas;

import java.util.ArrayList;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.Preguntas.PreguntaDao;
import ar.edu.unlam.tallerweb1.dao.Respuestas.RespuestaDao;
import ar.edu.unlam.tallerweb1.modelo.Pregunta;
import ar.edu.unlam.tallerweb1.modelo.Respuesta;


@Service("ServicioPregunta")
@Transactional
public class ServicioPreguntaImpl implements ServicioPregunta{

	@Inject
	private PreguntaDao PreguntaDao;
	
	@Inject
	private RespuestaDao respuestaDao;
	
	
	@Transactional
	public void grabarPregunta(Pregunta Pregunta){
		PreguntaDao.grabarPregunta(Pregunta);
		
	}
	
			
	@Transactional
	public Pregunta cargarPregunta(long IdPregunta){
		return PreguntaDao.cargarPregunta(IdPregunta);
	}
	
	@Transactional
	public boolean borrarPregunta( long IdPregunta){
		Pregunta pregunta;
		ArrayList <Respuesta> respuesta;
				
		pregunta = cargarPregunta(IdPregunta);
		respuesta= (ArrayList<Respuesta>) pregunta.getRespuestas();
		
		for (int i=0; i< respuesta.size();i++){	
			respuestaDao.borrarRespuesta(respuesta.get(i));	
		}
		
		return PreguntaDao.borrarPregunta(pregunta);
	}

}