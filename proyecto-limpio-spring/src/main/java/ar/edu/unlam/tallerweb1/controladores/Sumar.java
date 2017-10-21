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
	public ModelAndView sumar(@PathVariable String operando1, @PathVariable String operando2, @PathVariable String suma) {
		
		if((operando1.matches("[0-9]*")) && (operando2.matches("[0-9]*"))&&("+".equals(suma)))
		{
			
			int operando1Int = Integer.parseInt(operando1);
			int operando2Int = Integer.parseInt(operando2);
			int resultado =  operando1Int + operando2Int;
			String mensaje = "El resultado de Sumar " + operando1 + " y " + operando2 + " da = " + resultado;
			ModelMap model = new ModelMap();
			
			model.put("operacion", mensaje);//"operacion": lo que mostrara la vista, adentro tiene a mensaje.
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