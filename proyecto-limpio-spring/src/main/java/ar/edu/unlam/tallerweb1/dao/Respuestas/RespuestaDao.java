package ar.edu.unlam.tallerweb1.dao.Respuestas;


import ar.edu.unlam.tallerweb1.modelo.Respuesta;


public interface RespuestaDao {
	
	public void grabarRespuesta(Respuesta Respuesta);	
	public Respuesta nomRespuesta(long idRta);

	
}