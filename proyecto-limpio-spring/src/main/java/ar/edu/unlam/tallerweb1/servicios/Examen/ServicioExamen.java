
package ar.edu.unlam.tallerweb1.servicios.Examen;
import java.util.ArrayList;
import ar.edu.unlam.tallerweb1.modelo.Examen;
import ar.edu.unlam.tallerweb1.modelo.Nota;
import ar.edu.unlam.tallerweb1.modelo.Pregunta;
import ar.edu.unlam.tallerweb1.modelo.Respuesta;


public interface ServicioExamen {

	public ArrayList<Examen> cargarExamen();
	
	public Examen cargarExamen(long Idexamen);
	public Examen cargarExamenDinamico(long Idcurso);
	public ArrayList<Respuesta> corregirRta(String[] rta);
	public ArrayList<Pregunta> cargarPreguntaPorExamen(long Idexamen);	
	public float GetNotaExamen(ArrayList <Pregunta>  preguntas, long[] respuestas);
	public void GrabarNotaExamen(Nota nota);
	public long GrabarExamen(Examen examen);
	
}