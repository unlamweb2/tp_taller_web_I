package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Curso;
import ar.edu.unlam.tallerweb1.modelo.Examen;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.Alumno.ServicioAlumno;
import ar.edu.unlam.tallerweb1.servicios.Curso.ServicioCurso;
import ar.edu.unlam.tallerweb1.servicios.Usuario.ServicioUsuario;

@Controller
public class AlumnoControler {
	@Inject
	private ServicioUsuario serviciousuario;	
	@Inject
	private ServicioCurso servicioCurso;	
	@Inject
	private ServicioAlumno servicioAlumno;
	
	@RequestMapping(value="/IrAccionAlumno", method= RequestMethod.POST)	
	public ModelAndView homeAlumno(@RequestParam("IdCurso")long idCurso, @RequestParam("idAlumno")long idAlumno, @RequestParam("btnAction")String accion){
		ModelMap model = new ModelMap();	
		Curso curso = new Curso();	
		Usuario usuario = new Usuario();
		
		curso = servicioCurso.GetCurso(idCurso);
		usuario = serviciousuario.UsuarioporId(idAlumno);
		
		Examen examen = new Examen();	
		String vista="";
		
		switch (accion){
		case "Ver Examenes Pendientes": 
			model.put("Alumno", usuario);
			model.put("Curso", curso);			
			vista="listaExamenAlumno";									
			break;
		case "Ver Notas": 
			model.put("Curso", curso);	
			model.put("Examen", examen);			
			vista="altaExamenAlumnoDocente";				
			break;					
		case "Inscribirse a un Curso": 
			ArrayList <Curso> cursos = servicioCurso.cursosParaAnotarse();
			model.put("Cursos", cursos);			
			model.put("Alumno", usuario);
			vista="InscripcionAlumnoCurso";
		}	
		
		return new ModelAndView(vista, model);		
	}
	
	
	
	
	@RequestMapping("/ingresarAlumno")
	public ModelAndView ingresarAlumno()
	{
		ModelMap modelo = new ModelMap();
		Usuario alumno = new Usuario();
		modelo.put("Alumno", alumno);	
		return new ModelAndView("formularioIngresaAlumno", modelo);
	}
		
	
 @RequestMapping("/InscribirseCursoAlumno/{idAlumno}/{idCurso}")
 public ModelAndView InscribirCursoAlumno(@PathVariable long idAlumno,@PathVariable long idCurso)
 {
 		ModelMap model = new ModelMap();
 		
		
 		Curso curso = new Curso();
		curso = servicioCurso.GetCurso(idCurso);
		int canti= curso.getCantidadAlumnos();
		curso.setCantidadAlumnos(++canti);
				
		Usuario alumno = new Usuario();
		alumno = serviciousuario.UsuarioporId(idAlumno);		
		
		Collection<Curso>cursos = new ArrayList<Curso>();
		cursos = alumno.getCursos();
		
for (int i=0; i< cursos.size();i++){
			

}
		
		
		
		cursos.add(curso);
		alumno.setCursos(cursos);
		servicioAlumno.anotarAlumno(alumno);
		
		// servicioCurso.agregar(curso);
		
		
			
		 
		alumno = serviciousuario.UsuarioporId(idAlumno);
		cursos = servicioCurso.cursosParaAnotarse();
		
		model.put("Cursos", cursos);			
		model.put("Alumno", alumno);
		 
 		return new ModelAndView("InscripcionAlumnoCurso",model);
	} 
 
 
 @Inject
 private SessionFactory sessionFactory;
@RequestMapping(value="/guardarAlumno", method = RequestMethod.POST)
public ModelAndView guardarAlumno(@ModelAttribute ("Alumno") Usuario alumno)
{	ModelMap model = new ModelMap();
	    alumno.setRol("alumno");		
	    serviciousuario.grabarUsuario(alumno);	
	    
	    model.put("error", "Usuario creado con exito");
	    
		return new ModelAndView("redirect:/login",model);
}


@RequestMapping(value="/homeAlumno",method= RequestMethod.POST)
public String  IrHomeAlumno()
{		
	System.out.print("pasooooooo");
		 
		return ("redirect:/homeAlumno");
	} 	

}



	
