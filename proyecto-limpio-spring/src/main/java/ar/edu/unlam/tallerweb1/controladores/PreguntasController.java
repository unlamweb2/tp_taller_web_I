package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Pregunta;
import ar.edu.unlam.tallerweb1.servicios.Preguntas.ServicioPregunta;

@Controller 
public class PreguntasController{
	
	@RequestMapping("/cargarPreguntas")
	public ModelAndView cargarPreguntas()
	{
		ModelMap model = new ModelMap();
		Pregunta Pregunta = new Pregunta();
		model.put("Pregunta", Pregunta);
		return new ModelAndView("FormularioPreguntas", model);		
	}
	
	@Inject
	private ServicioPregunta crearPregunta;
	
	@RequestMapping(value="/guardarPregunta", method=RequestMethod.POST)
	public ModelAndView guardarPregunta(@ModelAttribute("Pregunta") Pregunta Pregunta)
	{
		ModelMap model = new ModelMap();
		model.put("pregunta", Pregunta);
		crearPregunta.grabarPregunta(Pregunta);
		return new ModelAndView("PreguntaExito", model);		
	
		
	}
}
	

