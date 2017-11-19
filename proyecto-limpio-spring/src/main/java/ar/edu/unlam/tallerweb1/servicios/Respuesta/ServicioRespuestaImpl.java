package ar.edu.unlam.tallerweb1.servicios.Respuesta;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.Respuestas.RespuestaDao;
import ar.edu.unlam.tallerweb1.modelo.Respuesta;


@Service("ServicioRespuesta")
@Transactional
public class ServicioRespuestaImpl implements ServicioRespuesta{

	@Inject
	private RespuestaDao RespuestaDao;
	
	@Transactional
	public void grabarRespuesta(Respuesta Respuesta){
		RespuestaDao.grabarRespuesta(Respuesta);
		
	}
	
			
}