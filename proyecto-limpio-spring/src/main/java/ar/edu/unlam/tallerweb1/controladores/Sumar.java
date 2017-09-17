package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Sumar {

	@RequestMapping(path = "/cualquierVerdura/{operando1}/{operando2}", method = RequestMethod.GET) // action
	public ModelAndView sumar(@PathVariable int operando1, @PathVariable int operando2) {
		
		int operacion = operando1 + operando2;
		String mensaje = "El resultado de Sumar " + operando1 + " y " + operando2 + "=" + operacion;

		

		ModelMap model = new ModelMap();
		model.put("op1", mensaje);
		model.put("op2", mensaje);
		model.put("operacion", mensaje);
		return new ModelAndView("Resultado", model);
	}

}
//http://localhost:8080/proyecto-limpio-spring/cualquierVerdura/3/6