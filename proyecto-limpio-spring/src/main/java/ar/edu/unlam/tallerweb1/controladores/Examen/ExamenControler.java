package ar.edu.unlam.tallerweb1.controladores.Examen;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.assertj.core.util.DateUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Examen;
import ar.edu.unlam.tallerweb1.modelo.Nota;
import ar.edu.unlam.tallerweb1.modelo.Pregunta;
import ar.edu.unlam.tallerweb1.modelo.Respuesta;
import ar.edu.unlam.tallerweb1.servicios.Examen.ServicioExamen;
import ar.edu.unlam.tallerweb1.servicios.Respuesta.ServicioRespuesta;;

@Controller
public class ExamenControler {
			
	@Inject
	private ServicioExamen examenServicio;
	private ServicioExamen GetExamen;
	@Inject
	private ServicioRespuesta traerNombres;

	@RequestMapping("/rendirExamen")
	public ModelAndView rendir (@RequestParam("idExamen")long idExamen,@RequestParam("nombre")String nombre ,@RequestParam("apellido")String apellido) {
			
		Examen examen = new Examen();	
		ModelMap model= new ModelMap();					
		//pido el examen con ID 1
		examen= examenServicio.cargarExamen((long)idExamen);
		model.put("Examen", examen);
		model.put("Nombre", nombre);
		model.put("Apellido", apellido);
		return new ModelAndView("homeExamen",model);		
	}
	
	//POSTA		
	@RequestMapping(path ="/corregir-examen", method=RequestMethod.POST)
	public ModelAndView CorregirExamen(@RequestParam("RespuestadelExamen")long[] checkboxValue, @RequestParam("IdExamen")long idExamen, HttpServletRequest request
			,@RequestParam("nombre")String nombre ,@RequestParam("apellido")String apellido)
	{		
		 ModelMap model = new ModelMap();
		 ArrayList <Pregunta> preguntas;
		 ArrayList <Respuesta> respuestas = new ArrayList<Respuesta>();
		 Examen examen;
		 Nota nota=new Nota(); 
		 Respuesta nombreRta = new Respuesta();
		 examen = examenServicio.cargarExamen(idExamen);
		 preguntas= examenServicio.cargarPreguntaPorExamen(idExamen);
		 
		 nota.setCalificacion( examenServicio.GetNotaExamen(preguntas, checkboxValue));			 
		 nota.setFecha(DateUtil.now().toString());
		 nota.setIdExamen(idExamen);
		 nota.setIdUsuario((long) request.getSession().getAttribute("idUsuario"));
		 
		 examenServicio.GrabarNotaExamen(nota);
		 			 		
		model.put("examen",examen);	 
		model.put("nota",nota.getCalificacion());
		
		//hacer un array que metraiga los nombres y pasarlo al modelo
		for(int i=0;i<checkboxValue.length;i++) 
	    {
		nombreRta = traerNombres.nomRespuesta(checkboxValue[i]);
		respuestas.add(nombreRta);
	    }
		model.put("Nombre", nombre);
		model.put("Apellido", apellido);
		//model.put("examen", respuestas);
		model.put("Mis_respuestas", respuestas);
		
		return new ModelAndView("Resultado", model);
	}


}
