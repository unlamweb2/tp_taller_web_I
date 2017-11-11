package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Curso;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.Curso.ServicioCurso;
import ar.edu.unlam.tallerweb1.servicios.Usuario.ServicioUsuario;


@Controller
public class UsuarioControler {
	@RequestMapping("/ingresarDocente")
	public ModelAndView ingresarDocente()
	{
		ModelMap modelo = new ModelMap();
		Usuario docente = new Usuario();
		modelo.put("docente", docente);
		return new ModelAndView("formularioIngresaDocente", modelo);
	}
	@Inject
	private ServicioUsuario registrarDocente;
	
	@RequestMapping(value="/guardarDocente", method = RequestMethod.POST)
	public ModelAndView guardarDocente(@ModelAttribute("docente")Usuario docente)
	{
	ModelMap model= new ModelMap();	
	docente.setRol("docente");
	registrarDocente.grabarUsuario(docente);
	return new ModelAndView("home",model);	
	}
	
	@RequestMapping("/ingresarAlumno")
	public ModelAndView ingresarAlumno()
	{
		ModelMap modelo = new ModelMap();
		Usuario alumno = new Usuario();
		modelo.put("alumno", alumno);
		return new ModelAndView("formularioIngresaAlumno", modelo);
	}
	
	/*@Inject
	private ServicioUsuario registrarDocente;*/
	
	@RequestMapping(value="/guardarAlumno", method = RequestMethod.POST)
	public ModelAndView guardarAlumno(@ModelAttribute("alumno")Usuario alumno)
	{
	ModelMap model= new ModelMap();	
	alumno.setRol("alumno");
	registrarDocente.grabarUsuario(alumno);
	return new ModelAndView("homeAlumno",model);	
	}
	
	/*@Inject
	private ServicioCurso BuscarCursos;
	@RequestMapping(value="/verCursos/{idUsuario}")
	public ModelAndView verCursos(@PathVariable(value="idUsuario")long idUsuario)
	{
	ModelMap model= new ModelMap();	
	ArrayList<Curso>cursos = new ArrayList<Curso>();
	cursos = BuscarCursos.consultarTodosLosCursos(idUsuario);
	model.put("CursosdelAlumno", cursos);
	return new ModelAndView("cursosAlumno",model);	
	}*/
	
	
}
	




	/*@RequestMapping(value="/guardarDocente", method = RequestMethod.POST)
	public ModelAndView guardarDocente(@ModelAttribute("docente")Docente docente, @RequestParam ("email")String email, 
			@RequestParam ("password") String password)
	{
	ModelMap model= new ModelMap();
	Usuario usuario = new Usuario(email, password);
	model.put("personas",docente);
	registrarDocente.grabarDocente(docente);
	registrarUsuario.grabarUsuario(usuario);
	return new ModelAndView("home",model);	
	}*/
	
	/*@Inject
	private ServicioUsuario registarUsuario;
	@Inject
	private ServicioDocente registrarDocente;
	@RequestMapping(value="/guardarDocente", method = RequestMethod.POST)
	public ModelAndView guardarDocente(@RequestParam ("nombre")String nombre, @RequestParam ("apellido")String apellido, 
			@RequestParam ("email")String email, @RequestParam ("password") String password)
	{
	ModelMap model= new ModelMap();
	Docente docente = new Docente(nombre, apellido);//debo poner en el model a usuario?
	Usuario usuario = new Usuario(email, password);
	model.put("docentes",docente);// para que le paso el docente en este caso? si va al home
	model.put("usuarios", usuario);
	registrarDocente.grabarDocente(docente);
	registarUsuario.grabarUsuario(usuario);
	return new ModelAndView("home",model);}*/

/*	@Inject
	private UsuarioServicios registarUsuario;
  @RequestMapping(value="/registracion",  method = RequestMethod.POST)
 public ModelAndView guardarUsuario(@ModelAttribute("usuario") Usuario usuario) {
registarUsuario.grabarUsuario(usuario);
ModelAndView registracion = new ModelAndView();
registracion.addObject("nombre", usuario.getNombre());
registracion.addObject("apellido", usuario.getApellido());
registracion.setViewName("registracionOk");
return registracion;
}*/