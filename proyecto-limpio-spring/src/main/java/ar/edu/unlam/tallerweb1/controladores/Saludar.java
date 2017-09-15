package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Saludar {
	
	@RequestMapping(value="/saludo")//action
	public ModelAndView saludar(@RequestParam ("nombre") String nombre)//metodo
	{
		
		String mensaje = "hola mi nombre es " + nombre;
		
		ModelMap model = new ModelMap();
		model.put("msg", mensaje);//esto es lo que le pasamos a la vista como parametro
		
		
		return new ModelAndView("Saludar", model); //nombre de la vista.Ver spring-servlet sufijo		
	}
}
//http://localhost:8080/proyecto-limpio-spring/saludo?nombre=ramiro