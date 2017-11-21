package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unlam.tallerweb1.modelo.Curso;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.Login.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.Curso.ServicioCurso;





@Controller
public class CursoControler {
	
	@Inject
	private ServicioCurso BuscarCursos;
	
	@Inject
	private ServicioLogin servicioLogin;
	
	@RequestMapping("/ingresarCurso")
	public ModelAndView ingresarCurso()
	{
				
	Curso curso = new Curso();
	ModelMap model = new ModelMap();	
	model.put("Materia", curso);
	return new ModelAndView("formularioIngresaCurso", model);		
	}
	
	
	
	@Inject
	private ServicioCurso registrarCurso;
	
	@RequestMapping(value="/guardarCurso", method = RequestMethod.POST)
	public ModelAndView guardarCurso(@ModelAttribute("curso")Curso curso)
	{
	ModelMap model= new ModelMap();
	
	model.put("materias",curso);
	registrarCurso.grabarCurso(curso);
	return new ModelAndView("home",model);//devuelve vista listado
	}	
}