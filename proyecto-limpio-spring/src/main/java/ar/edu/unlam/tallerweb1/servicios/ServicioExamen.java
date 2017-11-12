
package ar.edu.unlam.tallerweb1.servicios;
import java.util.ArrayList;
import ar.edu.unlam.tallerweb1.modelo.Examen;
import ar.edu.unlam.tallerweb1.modelo.Pregunta;
import ar.edu.unlam.tallerweb1.modelo.Respuesta;


public interface ServicioExamen {

	//public ArrayList<Examen> cargarExamen();
	
	public Examen cargarExamen(long Idexamen);
	public ArrayList<Respuesta> corregirRta(String[] rta);
	public ArrayList<Pregunta> cargarPreguntaPorExamen(long Idexamen);
	
}