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
import ar.edu.unlam.tallerweb1.servicios.Examen.ServicioExamen;;

@Controller
public class ExamenControler {
			
	@Inject
	private ServicioExamen examenServicio;
	private ServicioExamen GetExamen;
	
	//@RequestMapping("/rendirExamen")
	//public ModelAndView rendir(@RequestParam("IdExamen")long idExamen) {
	@RequestMapping("/rendirExamen")
	public ModelAndView rendir (@RequestParam("idExamen")long idExamen,@RequestParam("nombre")String nombre) {
			
		Examen examen = new Examen();	
		ModelMap model= new ModelMap();					
		//pido el examen con ID 1
		examen= examenServicio.cargarExamen((long)idExamen);
		model.put("Examen", examen);
		model.put("Nombre", nombre);
		return new ModelAndView("homeExamen",model);		
	}
	
			
	@RequestMapping(path ="/corregir-examen", method=RequestMethod.POST)
	public ModelAndView CorregirExamen(@RequestParam("RespuestadelExamen")long[] checkboxValue, @RequestParam("IdExamen")long idExamen, HttpServletRequest request)
	{		
		 ModelMap model = new ModelMap();
		 ArrayList <Pregunta> preguntas;
		 Examen examen;
		 Nota nota=new Nota(); 
		 
		 examen = examenServicio.cargarExamen(idExamen);
		 preguntas= examenServicio.cargarPreguntaPorExamen(idExamen);
		 
		 nota.setCalificacion( examenServicio.GetNotaExamen(preguntas, checkboxValue));			 
		 nota.setFecha(DateUtil.now().toString());
		 nota.setIdExamen(idExamen);
		 nota.setIdUsuario((long) request.getSession().getAttribute("idUsuario"));
		 
		 examenServicio.GrabarNotaExamen(nota);
		 			 		
		model.put("examen",examen);	 
		model.put("nota",nota.getCalificacion());		
		
		return new ModelAndView("Resultado", model);
	}
	
	@RequestMapping("/rendirExamenDinamico/{idCurso}")
		public ModelAndView rendir22(@PathVariable("idCurso") long idCurso) {
			
			Examen examen = new Examen();	
			ModelMap model= new ModelMap();					
			
			examen= GetExamen.cargarExamenDinamico(idCurso);
			model.put("Examen", examen);
			return new ModelAndView("homeExamen22",model);		
}
	@RequestMapping(path ="/corregir-examenDinamico", method=RequestMethod.POST)
		public ModelAndView validarLogin22(@RequestParam("RespuestadelExamen22")String[] checkboxValue22, @RequestParam(value="IdExamen")long idExamen22)
		{
			
			ModelMap model = new ModelMap();
			model.put("Respuesta", checkboxValue22);
			model.put("Examen", idExamen22);
			return new ModelAndView("Resultado22", model);
		}
}
