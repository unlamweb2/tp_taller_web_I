package ar.edu.unlam.tallerweb1.controladores;


import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;


@Controller
public class ControladorLogin {
	
	 @Inject
		private ServicioLogin servicioLogin;

	@RequestMapping("/login")
	public ModelAndView irALogin() {

		ModelMap modelo = new ModelMap();
		Usuario usuario = new Usuario();
		modelo.put("usuario", usuario);
		return new ModelAndView("login", modelo);
	}

	@RequestMapping(path = "/validar-login", method = RequestMethod.POST)
	public ModelAndView validarLogin(@ModelAttribute("usuario") Usuario usuario, HttpServletRequest request) {
		ModelMap model = new ModelMap();
		
		Usuario usuarioBuscado = servicioLogin.consultarUsuario(usuario);
		if (usuarioBuscado != null) {
			//request.getSession().setAttribute("ROL", usuarioBuscado.getRol());
			
			if(("docente".equals(usuarioBuscado.getRol())))
			{
				return new ModelAndView("redirect:/homeDocente");}
			else{
				if(("alumno".equals(usuarioBuscado.getRol())))
					{model.put("usuario", usuarioBuscado);
				return new ModelAndView("homeAlumno", model);}
				if(("admin".equals(usuarioBuscado.getRol())))
				return new ModelAndView("redirect:/home");
				model.put("error", "Usuario o clave incorrecta");
			}
			
		} else {
			// si el usuario no existe agrega un mensaje de error en el modelo.
			model.put("error", "Usuario o clave incorrecta");
		}
		return new ModelAndView("login", model);//como no existe te manda de vuelta al login
	}

	// Escucha la URL /home por GET, y redirige a una vista.
	@RequestMapping(path = "/home", method = RequestMethod.GET)
	public ModelAndView irAHome() {
		return new ModelAndView("home");
	}
	
	@RequestMapping(path = "/homeDocente", method = RequestMethod.GET)
	public ModelAndView irAHomeDocente() {
		return new ModelAndView("homeDocente");
	}
	

	// Escucha la url /, y redirige a la URL /login, es lo mismo que si se invoca la url /login directamente.
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ModelAndView inicio() {
		return new ModelAndView("redirect:/login");
	}
	

}
