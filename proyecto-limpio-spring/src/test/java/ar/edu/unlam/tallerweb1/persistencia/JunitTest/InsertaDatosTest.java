package ar.edu.unlam.tallerweb1.persistencia.JunitTest;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Examen;
import ar.edu.unlam.tallerweb1.modelo.Pregunta;
import ar.edu.unlam.tallerweb1.modelo.Respuesta;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public class InsertaDatosTest extends SpringTest{
	
		Usuario usuario;
	    Examen examen;
		Pregunta pregunta;
		Respuesta respuesta;
		
	    @Before
	    @Transactional @Rollback(false)
	    public void llenarDatosExamen()  
	    {   
	    	ArrayList <Respuesta> respuestas = new ArrayList();    	
	    	respuestas.add(new Respuesta("No soy",false));
	    	respuestas.add(new Respuesta("Yo soy",true));
	    	respuestas.add(new Respuesta("Yo estoy",true));
	    	
	    	ArrayList <Pregunta> preguntas = new ArrayList();
	    	  	    	    	
	    	Pregunta preg = new Pregunta();	    	
	    	preg.setNombre("I Am?");	
	    	preg.setRespuestas(respuestas);
	    	preguntas.add( preg); 
	    	    	    	
	    	examen = new Examen("Ingles 2","12/12/2018","final",preguntas);
	    	
	    	getSession().save(examen); 	        	
	    	
	    }
	    
	    @Before
	    @Transactional @Rollback(false)
	    public void CrearUsuarios(){
	    	
	    	usuario = new Usuario();
	    	
	    	usuario.setRol("alumno");
	    	usuario.setEmail("test@test");
	    	usuario.setPassword("1234");
	    	usuario.setNombre("Nombre");
	    	usuario.setApellido("apellido");
	    	   		    
	    	getSession().save(usuario); 	 
	    }
	    
	    @Test
	    @Transactional @Rollback(false)
	    public void RunTest()  
	    {   }
	    	
	    	
	    	
	    	
	    	
}
	
	
		    
		
	    	
