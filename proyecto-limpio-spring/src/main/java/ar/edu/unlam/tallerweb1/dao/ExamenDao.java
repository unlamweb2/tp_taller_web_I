package ar.edu.unlam.tallerweb1.dao;
import java.util.ArrayList;

import ar.edu.unlam.tallerweb1.modelo.Examen;
import ar.edu.unlam.tallerweb1.modelo.Pregunta;
import ar.edu.unlam.tallerweb1.modelo.Respuesta;

// Interface que define los metodos del DAO de Usuarios.
public interface ExamenDao {
	
	//ArrayList<Examen> cargarExamen ();
	 Examen cargarExamen(long Idexamen);
	 ArrayList<Respuesta> corregirRta(String[] rta);
	 ArrayList<Pregunta>  cargarPreguntaPorExamen(long Idexamen);	
}
	

