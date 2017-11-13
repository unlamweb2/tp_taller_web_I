package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Examen;
import ar.edu.unlam.tallerweb1.modelo.Pregunta;
import ar.edu.unlam.tallerweb1.modelo.Respuesta;
import ar.edu.unlam.tallerweb1.servicios.ServicioExamen;;

@Controller
public class ExamenControler {
			
	@Inject
	private ServicioExamen examenServicio;
	
	//@RequestMapping("/rendirExamen")
	//public ModelAndView rendir(@RequestParam("IdExamen")long idExamen) {
	@RequestMapping("/rendirExamen")
	public ModelAndView rendir() {
			
		Examen examen = new Examen();	
		ModelMap model= new ModelMap();					
		//pido el examen con ID 1
		examen= examenServicio.cargarExamen((long)1);
		model.put("Examen", examen);
		return new ModelAndView("homeExamen",model);		
	}
	
			
	@RequestMapping(path ="/corregir-examen", method=RequestMethod.POST)
	public ModelAndView CorregirExamen(@RequestParam("RespuestadelExamen")long[] checkboxValue, @RequestParam("IdExamen")long idExamen)
	{		
		 ModelMap model = new ModelMap();
		 ArrayList <Pregunta> preguntas;
		 Examen examen;
		 float nota=0; 
		 
		 examen = examenServicio.cargarExamen(idExamen);
		 preguntas= examenServicio.cargarPreguntaPorExamen(idExamen);
		 nota = examenServicio.GetNotaExamen(preguntas, checkboxValue);	
		 		
		model.put("examen",examen);	 
		model.put("nota",nota);		
		
		return new ModelAndView("Resultado", model);
	}
}