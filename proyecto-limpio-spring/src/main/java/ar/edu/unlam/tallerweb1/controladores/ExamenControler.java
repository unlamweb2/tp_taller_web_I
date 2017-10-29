package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Preguntas;
import ar.edu.unlam.tallerweb1.servicios.ServicioPreguntas;

@Controller
public class ExamenControler {
	ArrayList<Preguntas> pregunta = new ArrayList<Preguntas>();
	
	@Inject
	private ServicioPreguntas crearExamen;
	
	@RequestMapping("/rendirExamen")
	public ModelAndView rendir() {
		
		ModelMap model= new ModelMap();	
		pregunta= crearExamen.cargarPreguntas();
		model.put("ListadoPreguntas", pregunta);
		return new ModelAndView("homeExamen",model);	
		
	}

}
