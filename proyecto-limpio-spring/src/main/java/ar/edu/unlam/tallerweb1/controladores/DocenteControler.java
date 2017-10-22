package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unlam.tallerweb1.modelo.Docente;
//import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.Docente.ServicioDocente;
//import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;

@Controller
public class DocenteControler {
	@RequestMapping("/ingresarDocente")
	public ModelAndView ingresarDocente()
	{
		ModelMap modelo = new ModelMap();
		Docente docente = new Docente();
		modelo.put("docente", docente);
		return new ModelAndView("formularioIngresaDocente", modelo);
	}
	@Inject
	private ServicioDocente registrarDocente;
	
	@RequestMapping(value="/guardarDocente", method = RequestMethod.POST)
	public ModelAndView guardarDocente(@ModelAttribute("docente")Docente docente)
	{
	ModelMap model= new ModelMap();	
	registrarDocente.grabarDocente(docente);
	return new ModelAndView("home",model);	
	}
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