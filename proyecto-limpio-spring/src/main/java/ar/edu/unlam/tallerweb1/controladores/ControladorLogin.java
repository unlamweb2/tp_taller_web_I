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
	
//////////////////////////////////////////*FORMULARIO por POST*///////////////////////////////////////////////////////
/*@RequestMapping(path="/formulario")//path
public ModelAndView irAForm(){
ModelMap model = new ModelMap();// modelo que le paso a la vista
Persona persona = new Persona();// objeto que se pone en el modelo	
persona.setEmail("hola@hola.com");// setters de la clase
persona.setNombre("Juan");
persona.setApellido("Silva");
model.put("persona", persona);//pone el objeto seteado en el modelo
return new ModelAndView("formulario", model);//retorna la vista y el modelo que le pase
}

@RequestMapping(path="/saludo2", method=RequestMethod.POST) //cuando queremos cambiar algo en el servidor usamos post
public ModelAndView addContact(@ModelAttribute("persona") Persona persona)//"persona" se guarda en Persona persona 
{
ModelMap model = new ModelMap();
model.put("email", persona.getEmail());//getEmail devuelve el valor pasado por formulario
model.put("nombre", persona.getNombre());
model.put("apellido", persona.getApellido());
return new ModelAndView("confirmacion", model);	//la vista muestra los datos que le mande en el form		
}*/
//////////////////////////////////////////////////////////////////////////////////////////////////
/*@RequestMapping("/formulario2")//1ero este
public ModelAndView formulario(ArrayList<Persona>lista) {
return new ModelAndView("formulario2","command", new Persona());//devuelve vista formulario
}*/

//Mejorado, no hace falta el command, se usa el modelatributte en el form, tampoco es necesario pasar la lisa
/*@RequestMapping("/formulario2")//1ero este
public ModelAndView formulario() {
	ModelMap model = new ModelMap();
	Persona persona = new Persona();
	model.put("persona", persona);//pone el objeto seteado en el modelo
	return new ModelAndView("formulario2", model);}

/*@RequestMapping(value="/agregar", method = RequestMethod.POST)
public ModelAndView agregar(Persona per)
{
//Persona persona1= new Persona("pedro");
//lista.add(persona1);
lista.add(per);
return new ModelAndView("listado","command",lista);//devuelve vista listado
}*/

/*@RequestMapping(value="/agregar", method = RequestMethod.POST)
public ModelAndView agregar(@ModelAttribute("persona")Persona persona)
{
ModelMap model= new ModelMap();
lista.add(persona);
model.put("personas",lista);

return new ModelAndView("listado",model);//devuelve vista listado
}*/
//items="Colleciton,List or Array" en el foreach.Collection of items to iterate in the loop.
//var="name of scoped variable" Name of the scoped variable which holds the current item in the iteration.
//This variable’s type depends on the items in the iteration and has nested visibility.

/*@RequestMapping("/borrar/{nombre}")
public ModelAndView borrar(@PathVariable("nombre")String nombre) {
	ModelMap model = new ModelMap();
	model.put("nombre",nombre);
	return new ModelAndView("borrado", model);
}
@RequestMapping(value = "jstlForEach", method = RequestMethod.GET)
public String jstlForEach(ModelMap model) {
    
    lista.add(new Persona("mail1","Diego","Reinoso"));
    lista.add(new Persona("mail2","Eli","Perez"));
    model.put("employees",lista);
    return "VistaLista";
}*/


}
