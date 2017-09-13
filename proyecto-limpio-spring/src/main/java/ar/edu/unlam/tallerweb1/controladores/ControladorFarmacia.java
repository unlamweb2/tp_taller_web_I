package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Farmacia;

@Controller
public class ControladorFarmacia {
	
	@RequestMapping("/Farmacia")
	
	public ModelAndView Farmacia(){
		
		ModelMap modelo = new ModelMap();
		Farmacia Farmacia = new Farmacia();
		
		modelo.put("Farmacia", Farmacia);
		return new ModelAndView("Farmacia", modelo);
		
	}	
	
	@RequestMapping(path= "/obtener-Farmacias", method = RequestMethod.GET)
	
	public ModelAndView obtenerFarmacias(){
		ModelMap modelo = new ModelMap();
		
		
	}

}
