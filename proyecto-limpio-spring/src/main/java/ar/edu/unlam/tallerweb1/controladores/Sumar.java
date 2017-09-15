package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Sumar {

	@RequestMapping(path = "/cualquierVerdura/{operacion}/{operando1}/{operando2}", method = RequestMethod.GET) // action
	public ModelAndView sumar(@PathVariable String operacion, @PathVariable String operando1, @PathVariable String operando2) {

		String mensaje = "El resultado de Sumar" + operando1 + "y" + operando2 + "=" + operacion;

		operacion = operando1 + operando2;

		ModelMap model = new ModelMap();
		model.put("op1", mensaje);
		model.put("op2", mensaje);
		model.put("operacion", mensaje);
		return new ModelAndView("Resultado", model);
	}

}
