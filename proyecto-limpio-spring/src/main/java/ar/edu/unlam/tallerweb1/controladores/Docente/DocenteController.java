package ar.edu.unlam.tallerweb1.controladores.Docente;


import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import ar.edu.unlam.tallerweb1.modelo.Examen;
import ar.edu.unlam.tallerweb1.modelo.Pregunta;
import ar.edu.unlam.tallerweb1.modelo.Respuesta;
import ar.edu.unlam.tallerweb1.servicios.Examen.ServicioExamen;
import ar.edu.unlam.tallerweb1.servicios.Preguntas.ServicioPregunta;
import ar.edu.unlam.tallerweb1.servicios.Respuesta.ServicioRespuesta;


@Controller
public class DocenteController{
	
	
	/*ALTA EXAMEN*/
	
	@RequestMapping("/ingresarNuevoExamenDocente")
	
	public ModelAndView homeExamen()
	{
		
	Examen examen = new Examen();
		
	ModelMap Model = new ModelMap();
	Model.put("examenes", examen);
	return new ModelAndView("altaExamenDocente", Model);
		
	}
	
	@Inject ServicioExamen cargarExamen;
	
	@RequestMapping(value="/guardarExamen", method= RequestMethod.POST)	
	public ModelAndView altaExamen(@ModelAttribute("Examen") Examen examen){
		
		
		ModelMap modelExamen = new ModelMap();
		cargarExamen.cargarExamen(1);  /*revisar porque no tiene que ser por ID*/
		modelExamen.put("Examen", examen);
		return new ModelAndView("altaPreguntaDocente", modelExamen);				
		
	}

	/*ALTA PREGUNTA*/
	
	@RequestMapping("/ingresarNuevaPreguntaDocente")
	
	
	public ModelAndView homePregunta()
	{
		Pregunta pregunta = new Pregunta();
		
		ModelMap ModelPregunta = new ModelMap();
		ModelPregunta.put("pregunta", pregunta);
		return new ModelAndView("altaPreguntaDocente", ModelPregunta);	
	
		
	}
	
	@Inject ServicioPregunta grabarPregunta;
	
	@RequestMapping(value="/guardarPregunta", method=RequestMethod.POST)
	public ModelAndView altaPregunta(@ModelAttribute("Pregunta") Pregunta pregunta){
		
		ModelMap modelPregunta = new ModelMap();
		grabarPregunta.grabarPregunta(pregunta);  
		modelPregunta.put("Pregunta", pregunta);
		return new ModelAndView("altaPreguntaDocente");
				
		
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

