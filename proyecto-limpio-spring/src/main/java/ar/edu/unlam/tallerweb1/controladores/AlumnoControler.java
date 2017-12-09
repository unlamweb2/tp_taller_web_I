package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Curso;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.Alumno.ServicioAlumno;
import ar.edu.unlam.tallerweb1.servicios.Curso.ServicioCurso;
import ar.edu.unlam.tallerweb1.servicios.Usuario.ServicioUsuario;

@Controller
public class AlumnoControler {
	@Inject
	private ServicioUsuario registrarAlumno;
	@Inject
	private ServicioUsuario buscarUsuarioxId;
	
	@Inject
	private ServicioCurso Cursos;
	
	@Inject
	private ServicioAlumno inscribirAlumno;
	
	@RequestMapping("/ingresarAlumno")
	public ModelAndView ingresarAlumno()
	{
		ModelMap modelo = new ModelMap();
		Usuario alumno = new Usuario();
		modelo.put("Alumno", alumno);
		ArrayList<Curso>materias = new ArrayList<Curso>();
		materias = Cursos.cursosParaAnotarse();
		modelo.put("Chorizo", materias);	
		return new ModelAndView("formularioIngresaAlumno", modelo);
	}
	
	//Trae todos los cursos a los que puede anotarse el alumno
	@RequestMapping(value="/guardarAlumno", method = RequestMethod.POST)
	public ModelAndView guardarAlumno(@ModelAttribute("alumno")Usuario alumno, @RequestParam("idCurso") long idCurso)
	{
	ModelMap model= new ModelMap();	
	alumno.setRol("alumno");
	
	
	//ArrayList<Curso>cursos = new ArrayList<Curso>();
	//cursos = Cursos.cursosParaAnotarse();
	//model.put("Chorizo", cursos);LA VISTA LOS RECIBE PERFECTO. COMPROBADO
	//model.put("Alumno", alumno);
	Curso curso = new Curso();
	curso = Cursos.GetCurso(idCurso);
	alumno.setCursos(curso);
	registrarAlumno.grabarUsuario(alumno);

	return new ModelAndView("redirect:/login");	
	}
}
	
