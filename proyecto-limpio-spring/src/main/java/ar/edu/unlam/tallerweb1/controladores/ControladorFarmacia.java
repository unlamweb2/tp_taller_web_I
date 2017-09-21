package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Farmacia;

@Controller
public class ControladorFarmacia {
	
	ArrayList<Farmacia> listaFarmacia = new ArrayList<Farmacia>();
	
	@RequestMapping("/Farmacia")
	
	public ModelAndView consultarFarmaciaDiaMartes(Farmacia farmacia){
		
		ModelMap modelo = new ModelMap();
		//Farmacia Farmacia = new Farmacia();
		
		//modelo.put("Farmacia", Farmacia);
		listaFarmacia.add(farmacia);
		return new ModelAndView("Farmacia","command", listaFarmacia);//"Farmacia" es la vista
		
	}	
	
	/*@RequestMapping(path= "/obtener-Farmacias", method = RequestMethod.GET)
	
	public ModelAndView obtenerFarmacias(){
		ModelMap modelo = new ModelMap();
		
		
	}*/

}
