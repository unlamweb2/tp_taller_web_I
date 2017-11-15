package ar.edu.unlam.tallerweb1.controladores.Docente;

import java.util.ArrayList;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import ar.edu.unlam.tallerweb1.modelo.Examen;


@Controller
public class DocenteController{
	
	@RequestMapping("/ingresarNuevoExamenDocente")
	
	public ModelAndView homeExamen()
	{
	
	ModelMap Model = new ModelMap();
	ArrayList<Examen>examen = new ArrayList<Examen>();
	Model.put("examenes", examen);
	return new ModelAndView("altaExamenDocente", Model);
	
	
	}
}
