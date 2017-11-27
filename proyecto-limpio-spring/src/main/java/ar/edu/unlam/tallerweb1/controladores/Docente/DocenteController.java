package ar.edu.unlam.tallerweb1.controladores.Docente;


import java.awt.Checkbox;
import java.util.ArrayList;

import javax.inject.Inject;

import org.junit.Assert;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	/*VISTA RESPUESTA*/
	@Inject ServicioPregunta servicioPregunta;
	@Inject ServicioExamen getExamen;
	
	@RequestMapping ("/guardarRespuestaDocente/{idExamen}/{idPregunta}")
	public ModelAndView homeRespuesta(@PathVariable long idExamen, @PathVariable long idPregunta){
	
		
	ModelMap ModelRespuesta = new ModelMap();
	
	
	Examen examen = getExamen.cargarExamen((long)idExamen); 
	Pregunta pregunta = servicioPregunta.cargarPregunta((long)idPregunta);
	Respuesta respuesta = new Respuesta();	
	
	
	ModelRespuesta.put("examen", examen);
	ModelRespuesta.put("pregunta", pregunta);
	ModelRespuesta.put("respuesta", respuesta);
	
	return new ModelAndView ("altaRespuestaDocente", ModelRespuesta);		
	}
	
	
	/*ALTA RESPUESTA*/
	@Inject ServicioPregunta preguntaServicio;
	@Inject ServicioRespuesta grabarRespuesta;
	@Inject ServicioExamen examenServicio1;
	@RequestMapping(value="/guardarRespuestaDocenteok", method=RequestMethod.POST)	
	public ModelAndView altRespuesta(@RequestParam ("idExamen") long idExamen, @RequestParam ("idPregunta") long idPregunta,
									 @ModelAttribute("respuesta") Respuesta respuesta){
		
		
		ModelMap ModelRespuesta = new ModelMap();
		
		/*traigo el examen de la base por id*/
		Examen examen = new Examen();	
		examen= examenServicio.cargarExamen((long)idExamen);
		
		/*traigo la pregunta de la base por id*/
		Pregunta pregunta = new Pregunta();
		pregunta= preguntaServicio.cargarPregunta((long) idPregunta);
		
		
		/*relaciono el examen con la pregunta y la guardo */
		pregunta.setExamen(examen);		
		grabarPregunta.grabarPregunta(pregunta);
		
		
		
		
		/*relaciono la pregunta con la respuesta y la guardo */
		respuesta.setPregunta(pregunta);
		grabarRespuesta.grabarRespuesta(respuesta);
		
		
		
		/*seteo la lógica del CheckBox*/		
		Respuesta respuestaok = new Respuesta();
		
		Checkbox checkbox = new Checkbox();
		
		if(checkbox.isEnabled())
		    {
				respuestaok.setCorrecta(true);
			}
		else if(checkbox.isEnabled()==false);
			{	
				respuestaok.setCorrecta(false);
			}			
		ModelRespuesta.put("checkbox", checkbox);
		
		/*mando la pregunta para poder mostrar todas las respuestas del mismo con un for en la vista*/
		pregunta= preguntaServicio.cargarPregunta((long) idPregunta);
		ModelRespuesta.put("pregunta", pregunta);
			
		
		/*creo y mando una nueva instancia de respuesta para poder dar de alta otra*/
		respuesta= new Respuesta();		
		ModelRespuesta.put("respuesta", respuesta);
		
		return new ModelAndView ("altaRespuestaListado", ModelRespuesta);
		
	}
	
		  
}

		


