package ar.edu.unlam.tallerweb1.servicios.Docente;

import ar.edu.unlam.tallerweb1.modelo.Docente;


public interface ServicioDocente {

	public void grabarDocente(Docente docente);
	Docente consultarDocente(Docente docente);
	Docente consultarRol(Docente docente);
}
