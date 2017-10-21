package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PersonaControler {
	
	public String nombres = "juan"; 
	
	@RequestMapping("/mostrar/Nombre")
	public ModelAndView saludoInicial(@RequestParam("nombre")String nombre){
		String mensaje = "hola, " + nombre;
		
		ModelMap model = new ModelMap();
		
		model.put("mensajeMostrar", mensaje);
		
		return new ModelAndView("vistaAInvocar", model);
		
	}//Ejecutar asi 
	//http://localhost:8080/proyecto-limpio-spring/mostrar/Nombre?nombre=Diego
		
		@RequestMapping("/mostrar/{nombre2}")
		public ModelAndView saludoInicial2(@PathVariable(value="nombre2") String nombre2){
			String mensaje = "holaS, " + nombre2;
			
			ModelMap model = new ModelMap();
			
			model.put("mensajeMostrar", mensaje);
			
			return new ModelAndView("vistaAInvocar", model);	
		}//http://localhost:8080/proyecto-limpio-spring/mostrar/diego	
}