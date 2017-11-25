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
	@RequestMapping("/ingresarAlumno")
	public ModelAndView ingresarAlumno()
	{
		ModelMap modelo = new ModelMap();
		Usuario alumno = new Usuario();
		modelo.put("Alumno", alumno);
		return new ModelAndView("formularioIngresaAlumno", modelo);
	}
	
	@Inject
	private ServicioUsuario registrarAlumno;
	@Inject
	private ServicioUsuario buscarUsuarioxId;
	@Inject
	private ServicioCurso buscarCursosDisponibles;
	@Inject
	private ServicioAlumno inscribirAlumno;
	@Inject ServicioCurso serviciocurso;
	//@Inject
	//private ServicioCurso registrarCurso;
	
	//Trae todos los cursos a los que puede anotarse el alumno
	@RequestMapping(value="/guardarAlumno", method = RequestMethod.POST)
	public ModelAndView guardarAlumno(@ModelAttribute("alumno")Usuario alumno)
	{
	ModelMap model= new ModelMap();	
	alumno.setRol("alumno");
	registrarAlumno.grabarUsuario(alumno);
	
	ArrayList<Curso>cursos = new ArrayList<Curso>();
	cursos = buscarCursosDisponibles.cursosParaAnotarse();
	model.put("Chorizo", cursos);
	model.put("Alumno", alumno);
	return new ModelAndView("homeAlumnoSinMateria",model);	//LA VISTA LOS RECIBE PERFECTO. COMPROBADO
	}
	@RequestMapping(value="/inscribirAlumno", method = RequestMethod.POST)
	public ModelAndView guardarAlumno(@RequestParam("idCurso")long[] idCurso, @RequestParam("idAlumno")long idAlumno)
	{
		ModelMap model = new ModelMap();
		model.put("Materia", idCurso);
		model.put("Alumno", idAlumno);
		Usuario alumnoEncontrado = new Usuario();
		//aca hay que grabar
		//buscar usuario x id
		
		alumnoEncontrado = buscarUsuarioxId.UsuarioporId(idAlumno);
		
		//ArrayList<Usuario> alumnos= new ArrayList<Usuario>();
		ArrayList<Curso>cursos = new ArrayList<Curso>();
		Curso materia = new Curso();
		
	    for(int i=0;i<idCurso.length;i++) 
	    {
	        materia = serviciocurso.GetCurso(idCurso[i]);
	        System.out.println(materia.getId());//las trae bien
	        
	        cursos.add(materia);
	        //alumnos.add(alumnoEncontrado);ROMPE
	       	        
	      }
	  
	    //materia.setUsuarios(alumnos);ROMPE
		alumnoEncontrado.setCursos(cursos);
		inscribirAlumno.anotarAlumno(alumnoEncontrado);
		return new ModelAndView("Inscripcion", model);
	}

}
