package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;

import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Examen;
import ar.edu.unlam.tallerweb1.modelo.Pregunta;
import ar.edu.unlam.tallerweb1.modelo.Respuesta;
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
	
	@RequestMapping("/rendirExamen22/{idCurso}")
	public ModelAndView rendir22(@PathVariable("idCurso") long idCurso) {
		
		Examen examen = new Examen();	
		ModelMap model= new ModelMap();					
		//pido el examen con ID 1
		examen= GetExamen.cargarExamen(idCurso);
		model.put("Examen", examen);
		return new ModelAndView("homeExamen22",model);		
	}

	@RequestMapping(path ="/corregir-examen22", method=RequestMethod.POST)
	public ModelAndView validarLogin22(@RequestParam("RespuestadelExamen22")String[] checkboxValue22,@RequestParam("IdExamen22")long idExamen22)
	{
		//ArrayList<Respuesta> rta = new ArrayList<Respuesta>();
		 ModelMap model = new ModelMap();
		// rta = GetExamen.corregirRta(checkboxValue);
		// 
		model.put("Respuesta", checkboxValue22);
		model.put("Examen", idExamen22);
		return new ModelAndView("Resultado22", model);
	}
	
	@RequestMapping(path ="/corregir-examen", method=RequestMethod.POST)
	public ModelAndView validarLogin( @RequestParam(value="IdExamen", required = false)long idExamen,@RequestParam("RespuestadelExamen")long[] checkboxValue)
	{		
		 ModelMap model = new ModelMap();
		 int aciertos=0; 
		 
				 
		 ArrayList <Pregunta>  pregunta;
		 ArrayList<Respuesta>  respuesta;
		 //List<Respuesta>  respuesta;
		 
		 pregunta= GetExamen.cargarPreguntaPorExamen(idExamen);
				
			for (int i=0; i< pregunta.size();i++){
				
				respuesta = (ArrayList<Respuesta>) pregunta.get(i).getRespuestas();
				//respuesta =  pregunta.get(i).getRespuestas();								
				for (int j=0; j< respuesta.size();j++){
					
					for (int z=0; z< checkboxValue.length;z++){
						
						if (respuesta.get(j).getId()==(long) checkboxValue[z] ){
							
							if (respuesta.get(j).getCorrecta()){
								aciertos++;
							}								
						}							
					}					
				
			}
			
			}
						
									
			model.put("Respuesta",aciertos);
			 
			 
		
		return new ModelAndView("Resultado", model);
	}
}

