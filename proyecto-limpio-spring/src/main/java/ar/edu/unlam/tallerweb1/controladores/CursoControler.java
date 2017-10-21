package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unlam.tallerweb1.modelo.Curso;
import ar.edu.unlam.tallerweb1.servicios.ServicioCurso;





@Controller
public class CursoControler {
	@RequestMapping("/ingresarCurso")
	public ModelAndView ingresarCurso()
	{
		ModelMap modelo = new ModelMap();
		Curso curso = new Curso();
		modelo.put("curso", curso);
		return new ModelAndView("formularioIngresaCurso", modelo);
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