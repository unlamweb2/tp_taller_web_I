package ar.edu.unlam.tallerweb1.dao;
import java.util.ArrayList;

import ar.edu.unlam.tallerweb1.modelo.Preguntas;

// Interface que define los metodos del DAO de Usuarios.
public interface PreguntasDao {
	
	ArrayList<Preguntas> cargarPreguntas ();
}
	