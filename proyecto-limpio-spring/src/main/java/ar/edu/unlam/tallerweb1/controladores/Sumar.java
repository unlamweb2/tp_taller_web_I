package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Sumar {

	@RequestMapping(path = "/cualquierVerdura/{operando1}/{operando2}/{suma}", method = RequestMethod.GET) // action
	public ModelAndView sumar(@PathVariable int operando1, @PathVariable int operando2, @PathVariable String suma) {
		
		if((operando1==3) && (operando2== 6)&&("+".equals(suma)))
		{
			int resultado = operando1 + operando2;
			String mensaje = "El resultado de Sumar " + operando1 + " y " + operando2 + " da = " + resultado;
			ModelMap model = new ModelMap();
			model.put("op1", mensaje);
			model.put("op2", mensaje);
			model.put("operacion", mensaje);
			return new ModelAndView("Resultado", model);	
		}
		else
		{
			ModelMap modelerror = new ModelMap();
			String mensajeError = "NO PUDO REALIZARSE LA OPERACION" ;
			modelerror.put("operacionTrunca", mensajeError);
			return new ModelAndView("Error", modelerror);//"Error es la vista"
		}
	}
}
//http://localhost:8080/proyecto-limpio-spring/cualquierVerdura/3/6/+