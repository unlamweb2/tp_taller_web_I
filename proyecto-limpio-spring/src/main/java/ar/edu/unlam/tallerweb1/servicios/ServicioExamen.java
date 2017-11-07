
package ar.edu.unlam.tallerweb1.servicios;
import java.util.ArrayList;
import ar.edu.unlam.tallerweb1.modelo.Examen;
import ar.edu.unlam.tallerweb1.modelo.Pregunta;


public interface ServicioExamen {

	public ArrayList<Examen> cargarExamen();
	
	public Examen cargarExamen(long Idexamen);
	
	public ArrayList<Pregunta> cargarPreguntaPorExamen(long Idexamen);
				
	
}