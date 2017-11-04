package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Examen;
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

}
