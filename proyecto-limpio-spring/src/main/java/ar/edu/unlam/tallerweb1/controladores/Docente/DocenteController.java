package ar.edu.unlam.tallerweb1.controladores.Docente;


import java.util.ArrayList;

import javax.inject.Inject;

import org.junit.Assert;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Curso;
import ar.edu.unlam.tallerweb1.modelo.Examen;
import ar.edu.unlam.tallerweb1.modelo.Pregunta;
import ar.edu.unlam.tallerweb1.modelo.Respuesta;
import ar.edu.unlam.tallerweb1.servicios.Curso.ServicioCurso;
import ar.edu.unlam.tallerweb1.servicios.Examen.ServicioExamen;
import ar.edu.unlam.tallerweb1.servicios.Preguntas.ServicioPregunta;
import ar.edu.unlam.tallerweb1.servicios.Respuesta.ServicioRespuesta;


@Controller
public class DocenteController{
	
	
	/*ALTA EXAMEN*/
	@Inject ServicioCurso serviciocurso;
	@RequestMapping("/ingresarNuevoExamenDocente")	
	public ModelAndView homeExamen()
	{
	ArrayList<Curso> curso = new ArrayList<Curso>();	
	curso = serviciocurso.cursosParaAnotarse();
			
	Examen examen = new Examen();		
	ModelMap Model = new ModelMap();
	
	Model.put("Curso", curso);
	Model.put("Examen", examen);
	
	return new ModelAndView("altaExamenDocente", Model);
		
	}
	
	@Inject ServicioExamen cargarExamen;	
	@RequestMapping(value="/guardarExamen", method= RequestMethod.POST)	
	public ModelAndView altaExamen(@RequestParam("IdCurso")long idCurso, @ModelAttribute("Examen") Examen examen){
		
		Pregunta pregunta = new Pregunta();
		
		ModelMap modelExamen = new ModelMap();
		Curso curso = new Curso();
		curso = serviciocurso.GetCurso(idCurso);
		examen.setCurso(curso);
							
		cargarExamen.GrabarExamen(examen);
								
		modelExamen.put("examen", examen);		
		modelExamen.put("pregunta", pregunta);
		
		return new ModelAndView("altaPreguntaDocente", modelExamen);			
		
	}

	
	@Inject ServicioExamen examenServicio;
	@Inject ServicioPregunta grabarPregunta;	
	@RequestMapping(value="/guardarPregunta", method=RequestMethod.POST)
	public ModelAndView altaPregunta(@RequestParam("IdExamen")long idExamen,@ModelAttribute("pregunta") Pregunta pregunta){
		ModelMap modelPregunta = new ModelMap();
		
		/*traigo el examen de la base por id*/
		Examen examen = new Examen();	
		examen= examenServicio.cargarExamen((long)idExamen);
		/*relaciono el examen con la pregunta y la guardo */
		pregunta.setExamen(examen);		
		grabarPregunta.grabarPregunta(pregunta); 
		
		/*mando el examen para poder mostrar todas las preguntas del mismo con un for en la vista*/
		examen= examenServicio.cargarExamen((long)idExamen);
		modelPregunta.put("examen", examen);	
		/*creo y mando una nueva instancia de pregunta para poder dar de alta otra*/
		pregunta=new Pregunta();
		modelPregunta.put("pregunta", pregunta);
		
		return new ModelAndView("altaPreguntaDocente",modelPregunta);
				
		
	}
	
	/*ALTA RESPUESTA*/
	
	@RequestMapping("ingresarNuevaRespuestaDocente")	
	public ModelAndView homeRespuesta()
	{
		Respuesta respuesta = new Respuesta();
		
		ModelMap ModelRespuesta = new ModelMap();
		ModelRespuesta.put("Respuesta", respuesta);
		return new ModelAndView ("altaRespuestaDocente", ModelRespuesta);
			
		
	}
	
	@Inject ServicioRespuesta grabarRespuesta;	
	@RequestMapping(value="/guardarRespuesta", method=RequestMethod.POST)
	public ModelAndView altaRespuesta(@ModelAttribute("Respuesta") Respuesta respuesta){
		
		ModelMap modelRespuesta = new ModelMap();
		grabarRespuesta.grabarRespuesta(respuesta);
		modelRespuesta.put("Respuesta", respuesta);
		return new ModelAndView ("vistaExitoCargaExamen");		
		
	}
	
	
	
}

