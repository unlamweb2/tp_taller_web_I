package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Examen;
import ar.edu.unlam.tallerweb1.modelo.Respuesta;
import ar.edu.unlam.tallerweb1.servicios.ServicioExamen;;

@Controller
public class ExamenControler {
			
	@Inject
	private ServicioExamen GetExamen;
	
	@RequestMapping("/rendirExamen")
	public ModelAndView rendir() {
		
		Examen examen = new Examen();	
		ModelMap model= new ModelMap();					
		//pido el examen con ID 1
		examen= GetExamen.cargarExamen((long)1);
		model.put("Examen", examen);
		return new ModelAndView("homeExamen",model);		
	}
	
	/*@RequestMapping(path ="/corregir-examen", method=RequestMethod.POST)
	public ModelAndView validarLogin(@ModelAttribute("Respuesta") ArrayList<Respuesta> respuesta, HttpServletRequest request)
	{
		 ModelMap model = new ModelMap();
		model.put("Respuesta", respuesta);
		return new ModelAndView("Resultado", model);
	}*/
	@RequestMapping(path ="/corregir-examen", method=RequestMethod.POST)
	public ModelAndView validarLogin(String[] checkboxValue,long id)
	{
		ArrayList<Respuesta> rta = new ArrayList<Respuesta>();
		 ModelMap model = new ModelMap();
		// rta = GetExamen.corregirRta(checkboxValue);
		model.put("Respuesta", checkboxValue);
		model.put("Respuesta", id);
		return new ModelAndView("Resultado", model);
	}
}
